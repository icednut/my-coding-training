package io.icednut.algorithm_exercise.leetcode.q200

object Solution {
  def numIslands(grid: Array[Array[Char]]): Int = {
    var numIslands = 0

    for (i <- 0 until grid.length) {
      for (j <- 0 until grid(i).length) {
        if (grid(i)(j) == '1') {
          dfs(grid, (i, j))
          numIslands += 1
        }
      }
    }

    numIslands
  }

  private def dfs(grid: Array[Array[Char]], current: (Int, Int)): Unit = {
    // current는 x로 치환하고
    grid(current._1)(current._2) = 'x'
    // left 탐색
    if (current._2 - 1 >= 0 && grid(current._1)(current._2 - 1) == '1') {
      dfs(grid, (current._1, current._2 - 1))
    }
    // right 탐색
    if (current._2 + 1 < grid(current._1).length && grid(current._1)(current._2 + 1) == '1') {
      dfs(grid, (current._1, current._2 + 1))
    }
    // up 탐색
    if (current._1 - 1 >= 0 && grid(current._1 - 1)(current._2) == '1') {
      dfs(grid, (current._1 - 1, current._2))
    }
    // down 탐색
    if (current._1 + 1 < grid.length && grid(current._1 + 1)(current._2) == '1') {
      dfs(grid, (current._1 + 1, current._2))
    }
  }
}