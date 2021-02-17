package io.icednut.algorithm_exercise.leetcode.q315

import org.scalatest.funsuite.AnyFunSuite

class SolutionTest extends AnyFunSuite {

  test("case 01") {
    assert(Solution.countSmaller(Array(5, 2, 6, 1)) === Array(2, 1, 1, 0))
  }
}
