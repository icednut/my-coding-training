package io.icednut.leetcode.exercise.day10.q300

class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        var cache = Array(nums.size) { listOf<Int>() }

        for (i in 0..nums.lastIndex) {
            val newCache = go(cache, nums, i)
            cache = newCache
        }
        return cache.maxBy { it.size }?.size ?: 0
    }

    private fun go(cache: Array<List<Int>>, nums: IntArray, startIndex: Int): Array<List<Int>> {
        val newCache = cache.copyOf()
        var lastStepValue = if (newCache[startIndex].isNotEmpty()) newCache[startIndex].last() else -1

        for (i in startIndex..nums.lastIndex) {
            if (nums[i] > lastStepValue) {
                lastStepValue = nums[i]
                newCache[startIndex] = newCache[startIndex] + lastStepValue
                if (startIndex != i) {
                    newCache[i] = newCache[i] + lastStepValue
                }
            }
            if (nums[i] > nums[startIndex]
                && lastStepValue > nums[i]
                && isNewMaxLis(nums, i, newCache, startIndex)
            ) {
                newCache[startIndex] = newCache[startIndex].filter { it < nums[i] }
                newCache[startIndex] = newCache[startIndex] + nums[i]
            }
        }
        return newCache
    }

    private fun isNewMaxLis(nums: IntArray, index: Int, cache: Array<List<Int>>, startIndex: Int): Boolean {
        var newLis = cache.copyOf()
        newLis[startIndex] = newLis[startIndex].filter { it < nums[index] }
        newLis = go(newLis, nums, index) // TODO 이전 캐시의 값이 갱신이 안되는 이슈가 있음
        val pastLis = go(cache.copyOf(), nums, index)

        return newLis[startIndex].size >= pastLis[startIndex].size
    }
}
