package io.icednut.algorithm_exercise.leetcode.q39

import org.scalatest.funsuite.AnyFunSuite

class SolutionTest extends AnyFunSuite {

  test("case 01") {
    val candidates = Array(2, 3, 6, 7)
    val target = 7

    assert(Solution.combinationSum(candidates, target) === List(List(2, 2, 3), List(7)))
  }

  test("case 02") {
    val candidates = Array(2, 3, 5)
    val target = 8

    assert(Solution.combinationSum(candidates, target) === List(List(2, 2, 2, 2), List(2, 3, 3), List(3, 5)))
  }

  test("case 03") {
    val candidates = Array(2)
    val target = 1

    assert(Solution.combinationSum(candidates, target) === List())
  }

  test("case 04") {
    val candidates = Array(1)
    val target = 1

    assert(Solution.combinationSum(candidates, target) === List(List(1)))
  }

  test("case 05") {
    val candidates = Array(1)
    val target = 2

    assert(Solution.combinationSum(candidates, target) === List(List(1, 1)))
  }

}
