package io.icednut.algorithm_exercise.leetcode.q200

import scala.collection.mutable
import scala.util.Try

object Solution {
  def numIslands(grid: Array[Array[Char]]): Int = {
    var numIslands = 0
    var visited = mutable.Map[(Int, Int), Boolean]()

    for (i <- 0 until grid.length) {
      for (j <- 0 until grid(i).length) {
        if (!isVisited((i, j), visited) && grid(i)(j) == '1') {
          val stack = new mutable.Stack[(Int, Int)]()

          push(stack, (i, j), visited)
          dfs(grid, stack, visited)
          numIslands += 1
        }
      }
    }

    numIslands
  }

  private def dfs(grid: Array[Array[Char]],
                  stack: mutable.Stack[(Int, Int)],
                  visited: mutable.Map[(Int, Int), Boolean]): Unit = {
    val newStandard = Try(stack.pop()).toOption

    newStandard match {
      case Some(position) =>
        visited.put(position, true)

        if (position._2 > 0 && !isVisited((position._1, position._2 - 1), visited) && grid(position._1)(position._2 - 1) == '1') {
          push(stack, (position._1, position._2 - 1), visited)
          dfs(grid, stack, visited)
        }
        if (position._2 < grid(position._1).length - 1 && !isVisited((position._1, position._2 + 1), visited) && grid(position._1)(position._2 + 1) == '1') {
          push(stack, (position._1, position._2 + 1), visited)
          dfs(grid, stack, visited)
        }
        if (position._1 > 0 && !isVisited((position._1 - 1, position._2), visited) && grid(position._1 - 1)(position._2) == '1') {
          push(stack, (position._1 - 1, position._2), visited)
          dfs(grid, stack, visited)
        }
        if (position._1 < grid.length - 1 && !isVisited((position._1 + 1, position._2), visited) && grid(position._1 + 1)(position._2) == '1') {
          push(stack, (position._1 + 1, position._2), visited)
          dfs(grid, stack, visited)
        }
      case None =>
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