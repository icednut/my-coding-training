package io.icednut.leetcode.exercise.day00.singlenumberii

/**
 * @author will.109
 * @date 2020/04/05
 **/
class Solution {
    fun singleNumber(nums: IntArray): Int = nums.asSequence()
        .groupBy { it }
        .mapValues { it.value.size }
        .entries
        .find { it.value == 1 }?.key ?: 0
}