package io.icednut.leetcode.exercise.day00.singlenumberiii

/**
 * @author will.109
 * @date 2020/04/05
 **/
class Solution {
    fun singleNumber(nums: IntArray): IntArray = nums.asSequence()
        .groupBy { it }
        .mapValues { it.value.size }.entries
        .groupBy { it.value }
        .mapValues { it.value.map { it.key } }.get(1)
        ?.toIntArray()
        ?: intArrayOf()
}