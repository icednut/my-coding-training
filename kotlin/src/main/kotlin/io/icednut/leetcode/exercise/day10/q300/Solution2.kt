package io.icednut.leetcode.exercise.day10.q300

import kotlin.math.max

class Solution2 {
    fun lengthOfLIS(nums: IntArray): Int {
        if (nums.size == 0) {
            return 0
        }
        val cache = Array(nums.size) { "" }
        return find(cache, nums, nums.lastIndex)
    }

    fun go(cache: Array<String>, nums: IntArray, startIndex: Int) {
        if (cache[startIndex].isNotBlank()) {
            return
        }

        var lastMinValue = nums[startIndex] + 1
        var cacheIndex = ""

        val targetIndex = startIndex
        for (index in targetIndex downTo 0) {
            if (nums[index] < lastMinValue) {
                lastMinValue = nums[index]
                cache[targetIndex] = "$lastMinValue," + cache[targetIndex]

                if (index != targetIndex) {
                    cacheIndex += "${index},"
                    for (cacheIdx in cacheIndex.split(",")) {
                        if (cacheIdx.isNotBlank() && !cache[cacheIdx.toInt()].contains("$lastMinValue")) {
                            cache[cacheIdx.toInt()] = "$lastMinValue," + cache[cacheIdx.toInt()]
                        }
                    }
                }
            }
        }
    }

    fun find(cache: Array<String>, nums: IntArray, startIndex: Int): Int {
        if (startIndex < 0) {
            return 1
        }
        var count = 0

        if (cache[startIndex].isNotBlank()) {
            count = cache[startIndex].split(",").size - 1
        } else {
            val minValueIndexes = nums.mapIndexed { idx, value -> Pair(idx, value) }
                .filter { it.second < nums[startIndex] && it.first < startIndex }
                .map { it.first }

            var maxLengthSubsequence = ""
            for (minValueIndex in minValueIndexes) {
                go(cache, nums, minValueIndex)
                maxLengthSubsequence =
                    if (cache[minValueIndex].split(",").size - 1 > maxLengthSubsequence.split(",").size - 1) {
                        cache[minValueIndex]
                    } else {
                        maxLengthSubsequence
                    }
            }
            cache[startIndex] = "$maxLengthSubsequence${nums[startIndex]},"
            count = cache[startIndex].split(",").size - 1
        }
        return max(count, find(cache, nums, startIndex - 1))
    }
}