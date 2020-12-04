package io.icednut.leetcode.exercise.day00.singlenumber

class Solution {
    fun singleNumber(nums: IntArray): Int = nums.asSequence()
        .groupBy { it }
        .mapValues { it.value.size }
        .entries
        .find { it.value == 1 }?.key ?: 0
}

class Solution2 {
    fun singleNumber(nums: IntArray): Int {
        var result = 0
        for (x in nums) {
            result = result xor x
        }
        return result
    }
}