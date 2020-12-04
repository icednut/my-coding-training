package io.icednut.algorithm_exercise.leetcode.q200

import org.scalatest.funsuite.AnyFunSuite

class SolutionTest extends AnyFunSuite {

  test("example 1") {
    val grid = Array(
      Array('1', '1', '1', '1', '0'),
      Array('1', '1', '0', '1', '0'),
      Array('1', '1', '0', '0', '0'),
      Array('0', '0', '0', '0', '0')
    )
    assert(Solution.numIslands(grid) == 1)
  }

  test("example 2") {
    val grid = Array(
      Array('1', '1', '0', '0', '0'),
      Array('1', '1', '0', '0', '0'),
      Array('0', '0', '1', '0', '0'),
      Array('0', '0', '0', '1', '1')
    )
    assert(Solution.numIslands(grid) == 3)
  }

  test("example 9") {
    val grid = Array(
      Array('0', '0', '0', '0', '0', '0', '1')
    )
    assert(Solution.numIslands(grid) == 1)
  }

  test("example 27") {
    val grid = Array(
      Array('1', '0', '1', '1', '0', '1', '1')
    )
    assert(Solution.numIslands(grid) == 3)
  }

  test("example 33") {
    val grid = Array(
      Array('1', '1', '1'),
      Array('0', '1', '0'),
      Array('1', '1', '1')
    )
    assert(Solution.numIslands(grid) == 1)
  }

  test("example 34") {
    val grid = Array(
      Array('1', '0', '1', '1', '1'),
      Array('1', '0', '1', '0', '1'),
      Array('1', '1', '1', '0', '1')
    )
    assert(Solution.numIslands(grid) == 1)
  }

  test("example 35") {
    val grid = Array(
      Array('1', '1', '1', '1', '1', '1', '1'),
      Array('0', '0', '0', '0', '0', '0', '1'),
      Array('1', '1', '1', '1', '1', '0', '1'),
      Array('1', '0', '0', '0', '1', '0', '1'),
      Array('1', '0', '1', '0', '1', '0', '1'),
      Array('1', '0', '1', '1', '1', '0', '1'),
      Array('1', '1', '1', '1', '1', '1', '1')
    )
    assert(Solution.numIslands(grid) == 1)
  }

  test("example 번외 1") {
    val grid = Array(
      Array('1', '1', '0', '0', '0'),
      Array('1', '1', '0', '0', '0'),
      Array('0', '0', '0', '0', '0'),
      Array('0', '0', '1', '0', '1')
    )
    assert(Solution.numIslands(grid) == 3)
  }

  test("example 번외 2") {
    val grid = Array(
      Array('1', '1', '1'),
      Array('0', '1', '0'),
      Array('1', '1', '1')
    )
    assert(Solution.numIslands(grid) == 1)
  }

  test("example 번외 3") {
    val grid = Array(
      Array('1', '0', '1'),
      Array('1', '1', '1'),
      Array('1', '0', '1')
    )
    assert(Solution.numIslands(grid) == 1)
  }

  test("example 번외 4") {
    val grid = Array(
      Array('1', '0', '1'),
      Array('1', '0', '1'),
      Array('1', '1', '1')
    )
    assert(Solution.numIslands(grid) == 1)
  }

  test("example 번외 5") {
    val grid = Array(
      Array('0'),
      Array('0'),
      Array('0'),
      Array('0'),
      Array('0'),
      Array('0'),
      Array('1')
    )
    assert(Solution.numIslands(grid) == 1)
  }
}
