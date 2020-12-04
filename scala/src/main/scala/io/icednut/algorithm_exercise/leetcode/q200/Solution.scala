package io.icednut.algorithm_exercise.leetcode.q200

import scala.collection.mutable
import scala.util.Try

object Solution {
  def numIslands(grid: Array[Array[Char]]): Int = {
    var numIslands = 0
    var visited = Array[(Int, Int)]()

    for (i <- 0 until grid.length) {
      for (j <- 0 until grid(i).length) {
        if (isNotVisited((i, j), visited) && grid(i)(j) == '1') {
          val stack = new mutable.Stack[(Int, Int)]()

          visited = dfs(grid, (i, j), stack, visited)
          numIslands += 1
        }
      }
    }

    numIslands
  }

  private def dfs(grid: Array[Array[Char]],
                  position: (Int, Int),
                  stack: mutable.Stack[(Int, Int)],
                  visited: Array[(Int, Int)]): Array[(Int, Int)] = {
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

    val newVisited = visited :+ position
    val newStandard = Try(stack.pop()).toOption

    if (newStandard.isDefined) {
      dfs(grid, newStandard.get, stack, newVisited)
    } else {
      newVisited
    }
  }

  private def push(stack: mutable.Stack[(Int, Int)], position: (Int, Int), visited: Array[(Int, Int)]): Unit =
    if (isNotVisited(position, visited)) {
      stack.push(position)
    }

  private def isNotVisited(position: (Int, Int), visited: Array[(Int, Int)]) = {
    visited.toSeq.find(elem => elem._1 == position._1 && elem._2 == position._2).isEmpty
  }
}