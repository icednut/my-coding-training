package io.icednut.algorithm_exercise.leetcode.q153

object Solution {
  def findMin(nums: Array[Int]): Int = {
    def run(targetNums: Array[Int]): Int = {
      if (targetNums.length == 2) {
        Math.min(targetNums(0), targetNums(1))
      } else if (targetNums.length == 1) {
        targetNums(0)
      } else {
        val middleIndex = targetNums.length / 2
        val frontNums = targetNums.slice(0, middleIndex)
        val backNums = targetNums.slice(middleIndex, targetNums.length)

        Math.min(run(frontNums), run(backNums))
      }
    }

    run(nums)
  }
}