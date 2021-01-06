package io.icednut.algorithm_exercise.leetcode.q542

import org.scalatest.funsuite.AnyFunSuite

class SolutionTest extends AnyFunSuite {

  test("case 01") {
    val matrix = Array(
      Array(0, 0, 0),
      Array(0, 1, 0),
      Array(0, 0, 0)
    )

    val result = Solution.updateMatrix(matrix = matrix)
    val expectedResult = Array(
      Array(0, 0, 0),
      Array(0, 1, 0),
      Array(0, 0, 0)
    )

    for {i <- 0 until matrix.length} {
      for {j <- 0 until matrix(i).length} {
        assert(result(i)(j) == expectedResult(i)(j))
      }
    }
  }

  test("case 02") {
    val matrix = Array(
      Array(0, 0, 0),
      Array(0, 1, 0),
      Array(1, 1, 1)
    )

    val result = Solution.updateMatrix(matrix = matrix)
    val expectedResult = Array(
      Array(0, 0, 0),
      Array(0, 1, 0),
      Array(1, 2, 1)
    )

    for {i <- 0 until matrix.length} {
      for {j <- 0 until matrix(i).length} {
        assert(result(i)(j) == expectedResult(i)(j))
      }
    }
  }

  test("case 03") {
    val matrix = Array(
      Array(0),
      Array(0),
      Array(0),
      Array(0),
      Array(0)
    )

    val result = Solution.updateMatrix(matrix = matrix)
    val expectedResult = Array(
      Array(0),
      Array(0),
      Array(0),
      Array(0),
      Array(0)
    )

    for {i <- 0 until matrix.length} {
      for {j <- 0 until matrix(i).length} {
        assert(result(i)(j) == expectedResult(i)(j))
      }
    }
  }
}
