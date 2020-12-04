package io.icednut.algorithm_exercise.leetcode.q200

import scala.collection.mutable
import scala.util.Try

object Solution {
  def numIslands(grid: Array[Array[Char]]): Int = {
    var numIslands = 0
    val visited = mutable.Map[(Int, Int), Boolean]()

    for (i <- 0 until grid.length) {
      for (j <- 0 until grid(i).length) {
        if (!isVisited((i, j), visited) && grid(i)(j) == '1') {
          val stack = new mutable.Stack[(Int, Int)]()

          push(stack, (i, j), visited)
          dfs(grid, (i, j), stack, visited)
          numIslands += 1
        }
      }
    }

    numIslands
  }

  private def dfs(grid: Array[Array[Char]],
                  position: (Int, Int),
                  stack: mutable.Stack[(Int, Int)],
                  visited: mutable.Map[(Int, Int), Boolean]): Unit = {
    if (position._2 > 0 && grid(position._1)(position._2 - 1) == '1') {
      push(stack, (position._1, position._2 - 1), visited)
    }
    if (position._2 < grid(position._1).length - 1 && grid(position._1)(position._2 + 1) == '1') {
      push(stack, (position._1, position._2 + 1), visited)
    }
    if (position._1 > 0 && grid(position._1 - 1)(position._2) == '1') {
      push(stack, (position._1 - 1, position._2), visited)
    }
    if (position._1 < grid.length - 1 && grid(position._1 + 1)(position._2) == '1') {
      push(stack, (position._1 + 1, position._2), visited)
    }

    visited.put(position, true)
    val newStandard = Try(stack.pop()).toOption

    if (newStandard.isDefined) {
      dfs(grid, newStandard.get, stack, visited)
    }
  }

  private def push(stack: mutable.Stack[(Int, Int)], position: (Int, Int), visited: mutable.Map[(Int, Int), Boolean]): Unit =
    if (!isVisited(position, visited)) {
      stack.push(position)
    }

  private def isVisited(position: (Int, Int), visited: mutable.Map[(Int, Int), Boolean]) = {
    visited.get((position._1, position._2)).isDefined
  }
}