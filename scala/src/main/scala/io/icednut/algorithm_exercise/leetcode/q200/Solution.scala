package io.icednut.algorithm_exercise.leetcode.q200

import scala.collection.mutable
import scala.util.Try

object Solution {
  def numIslands(grid: Array[Array[Char]]): Int = {
    var numIslands = 0

    for (i <- 0 until grid.length) {
      for (j <- 0 until grid(i).length) {
        if (grid(i)(j) == '1') {
          bfs(grid, (i, j))
          numIslands += 1
        }
      }
    }

    numIslands
  }

  private def bfs(grid: Array[Array[Char]], current: (Int, Int)): Unit = {
    var done = false
    val queue = new mutable.Queue[(Int, Int)]()
    var newCurrent = current

    while (!done) {
      // current는 x로 치환하고
      grid(newCurrent._1)(newCurrent._2) = 'x'

      // left 탐색
      if (newCurrent._2 - 1 >= 0 && grid(newCurrent._1)(newCurrent._2 - 1) == '1') {
        grid(newCurrent._1)(newCurrent._2 - 1) = 'x'
        queue.enqueue((newCurrent._1, newCurrent._2 - 1))
      }
      // right 탐색
      if (newCurrent._2 + 1 < grid(newCurrent._1).length && grid(newCurrent._1)(newCurrent._2 + 1) == '1') {
        grid(newCurrent._1)(newCurrent._2 + 1) = 'x'
        queue.enqueue((newCurrent._1, newCurrent._2 + 1))
      }
      // up 탐색
      if (newCurrent._1 - 1 >= 0 && grid(newCurrent._1 - 1)(newCurrent._2) == '1') {
        grid(newCurrent._1 - 1)(newCurrent._2) = 'x'
        queue.enqueue((newCurrent._1 - 1, newCurrent._2))
      }
      // down 탐색
      if (newCurrent._1 + 1 < grid.length && grid(newCurrent._1 + 1)(newCurrent._2) == '1') {
        grid(newCurrent._1 + 1)(newCurrent._2) = 'x'
        queue.enqueue((newCurrent._1 + 1, newCurrent._2))
      }

      Try(queue.dequeue()).toOption match {
        case Some(next) =>
          newCurrent = next
        case None =>
          done = true
      }
    }
  }
}