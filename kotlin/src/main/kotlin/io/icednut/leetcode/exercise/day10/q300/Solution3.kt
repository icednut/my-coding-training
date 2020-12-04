package io.icednut.leetcode.exercise.day10.q300

class Solution3 {
    fun lengthOfLIS(nums: IntArray): Int {
        val cache = Array(nums.size) { "" }
        for (index in nums.lastIndex downTo 0) {
            if (cache[index].isBlank()) {
                cache[index] = "${nums[index]}"
                lastMinValue(cache, nums, index, index, "")
            }
        }
        return cache.maxBy { it.split(",").size }?.split(",")?.size ?: 0
    }

    private fun lastMinValue(
        cache: Array<String>,
        nums: IntArray,
        targetIndex: Int,
        lastIndex: Int,
        cacheIndex: String
    ) {
        val nextMinValuePair = nums
            .mapIndexed { idx, value ->
                val newValue = if (value > nums[targetIndex]) -1 else value
                Pair(idx, newValue)
            }
            .filter { it.first < lastIndex }
            .filter { it.second > 0 }
            .maxBy { it.second }
            ?: return

        cache[targetIndex] = "${nextMinValuePair.second},${cache[targetIndex]}"
        var newCacheIndex = cacheIndex
        if (nextMinValuePair.first != lastIndex) {
            newCacheIndex += "${nextMinValuePair.first},"
        }
        for (index in newCacheIndex.split(",")) {
            val cacheIdx = if (index.isNotBlank()) index.toInt() else null

            if (cacheIdx != null && !cache[cacheIdx].contains(nextMinValuePair.first.toString())) {
                cache[cacheIdx] = "${nextMinValuePair.second},${cache[cacheIdx]}"
            }
        }
        lastMinValue(cache, nums, targetIndex, nextMinValuePair.first, newCacheIndex)
    }
}