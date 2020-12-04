package io.icednut.leetcode.exercise.day07

/**
 * @author will.109
 * @date 2020/04/27
 **/
class Solution {
    fun largestPerimeter(A: IntArray): Int {
        A.sortDescending()

        fun run(threePoint: IntArray, startIndex: Int): Int {
            if (threePoint.size < 3) {
                return 0
            }
            val largest = A[startIndex]
            if (largest < A[startIndex + 1] + A[startIndex + 2]) {
                return largest + A[startIndex + 1] + A[startIndex + 2]
            } else {
                val newStartindex = startIndex + 1
                return run(A.slice(newStartindex..(A.size - 1)).toIntArray(), newStartindex)
            }
        }

        return run(A, 0)
    }
}