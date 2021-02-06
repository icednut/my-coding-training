package io.icednut.algorithm_exercise.leetcode.q153

import org.scalatest.funsuite.AnyFunSuite

class SolutionTest extends AnyFunSuite {

  test("case 01") {
    val result = Solution.findMin(Array(3, 4, 5, 1, 2))

    assert(result == 1)
  }

  test("case 02") {
    val result = Solution.findMin(Array(4, 5, 6, 7, 0, 1, 2))

    assert(result == 0)
  }

  test("case 03") {
    val result = Solution.findMin(Array(11, 13, 15, 17))

    assert(result == 11)
  }
}
