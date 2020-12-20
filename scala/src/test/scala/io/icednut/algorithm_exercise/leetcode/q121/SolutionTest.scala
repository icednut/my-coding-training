package io.icednut.algorithm_exercise.leetcode.q121

import org.scalatest.funsuite.AnyFunSuite

class SolutionTest extends AnyFunSuite {

  test("case 01") {
    val prices = Array(7, 1, 5, 3, 6, 4)
    val maxProfit = Solution.maxProfit(prices = prices)

    assert(maxProfit == 5)
  }

  test("case 02") {
    val prices = Array(7, 6, 4, 3, 1)
    val maxProfit = Solution.maxProfit(prices = prices)

    assert(maxProfit == 0)
  }

  test("case 03") {
    val prices = Array(0, 1, 2, 9, 4, 5)
    val maxProfit = Solution.maxProfit(prices = prices)

    assert(maxProfit == 9)
  }

  test("case 04") {
    val prices = Array(6, 1, 6, 4, 3, 0, 2)
    val maxProfit = Solution.maxProfit(prices = prices)

    assert(maxProfit == 5)
  }

  test("case 05") {
    val prices = Array(6, 2, 5, 1, 3, 4, 5)
    val maxProfit = Solution.maxProfit(prices = prices)

    assert(maxProfit == 4)
  }

  test("case 06") {
    val prices = Array(9, 8, 6, 7, 5, 2, 6, 4, 1)
    val maxProfit = Solution.maxProfit(prices = prices)

    assert(maxProfit == 4)
  }

  test("case 07") {
    val prices = Array(2, 6, 4, 1)
    val maxProfit = Solution.maxProfit(prices = prices)

    assert(maxProfit == 4)
  }

  test("case 08") {
    val prices = Array[Int]()
    val maxProfit = Solution.maxProfit(prices = prices)

    assert(maxProfit == 0)
  }
}
