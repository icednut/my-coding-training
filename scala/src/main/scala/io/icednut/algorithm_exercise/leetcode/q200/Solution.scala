package io.icednut.algorithm_exercise.leetcode.q200

import scala.collection.mutable
import scala.util.Try

object Solution {
  def numIslands(grid: Array[Array[Char]]): Int = {
    var numIslands = 0
    var visited = Array[(Int, Int)]()

    for (i <- 0 until grid.length) {
      for (j <- 0 until grid(i).length) {
        if (!isVisited((i, j), visited) && grid(i)(j) == '1') {
          val stack = new mutable.Stack[(Int, Int)]()

          push(stack, (i, j), visited)
          visited = dfs(grid, stack, visited)
          numIslands += 1
        }
      }
    }

    numIslands
  }

  private def dfs(grid: Array[Array[Char]],
                  stack: mutable.Stack[(Int, Int)],
                  visited: Array[(Int, Int)]): Array[(Int, Int)] = {
    val newStandard = Try(stack.pop()).toOption

    newStandard match {
      case Some(position) =>
        var newVisited = visited :+ position

        if (position._2 > 0 && grid(position._1)(position._2 - 1) == '1') {
          push(stack, (position._1, position._2 - 1), newVisited)
          newVisited = dfs(grid, stack, newVisited)
        }
        if (position._2 < grid(position._1).length - 1 && grid(position._1)(position._2 + 1) == '1') {
          push(stack, (position._1, position._2 + 1), newVisited)
          newVisited = dfs(grid, stack, newVisited)
        }
        if (position._1 > 0 && grid(position._1 - 1)(position._2) == '1') {
          push(stack, (position._1 - 1, position._2), newVisited)
          newVisited = dfs(grid, stack, newVisited)
        }
        if (position._1 < grid.length - 1 && grid(position._1 + 1)(position._2) == '1') {
          push(stack, (position._1 + 1, position._2), newVisited)
          newVisited = dfs(grid, stack, newVisited)
        }
        newVisited
      case None =>
        visited
    }
  }

  private def push(stack: mutable.Stack[(Int, Int)], position: (Int, Int), visited: Array[(Int, Int)]): Unit =
    if (!isVisited(position, visited)) {
      stack.push(position)
    }

  private def isVisited(position: (Int, Int), visited: Array[(Int, Int)]) = {
    visited.toSeq.exists(elem => elem._1 == position._1 && elem._2 == position._2)
  }
}