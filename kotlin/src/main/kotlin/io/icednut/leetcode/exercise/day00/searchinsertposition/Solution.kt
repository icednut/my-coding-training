package io.icednut.leetcode.exercise.day00.searchinsertposition

/**
 * @author will.109
 * @date 2020/03/28
 **/
class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        fun binarySearch(nums: IntArray, startIndex: Int, endIndex: Int): Int {
            val middleIndex = (endIndex + startIndex) / 2

            if (startIndex >= endIndex) {
                if (nums[startIndex] >= target) {
                    return startIndex
                } else {
                    return startIndex + 1
                }
            }

            if (nums[middleIndex] > target) {
                return binarySearch(nums, startIndex, middleIndex - 1)
            } else if (nums[middleIndex] < target) {
                return binarySearch(nums, middleIndex + 1, endIndex)
            } else {
                return binarySearch(nums, middleIndex, middleIndex)
            }
        }

        val lastIndex = nums.lastIndex
        val startIndex = 0

        return binarySearch(nums, startIndex, lastIndex)
    }
}

class Solution2 {
    fun searchInsert(nums: IntArray, target: Int): Int {
        val find = nums.zip(0..nums.size)
            .find { it.first >= target }

        if (find != null) {
            return find.second
        } else if (nums.reversedArray()[0] < target) {
            return nums.size
        } else {
            return 0
        }
    }
}