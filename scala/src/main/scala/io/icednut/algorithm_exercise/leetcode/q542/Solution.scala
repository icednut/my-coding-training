package io.icednut.algorithm_exercise.leetcode.q542

import scala.collection.mutable

object Solution {
  def updateMatrix(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    val rowSize = matrix.length
    val columnSize = matrix(0).length
    val queue = mutable.Queue[(Int, Int)]()
    val distances = Array.fill(rowSize)(
      Array.fill(columnSize)(-1)
    )

    for {i <- 0 until matrix.length} {
      for {j <- 0 until matrix(i).length} {
        if (matrix(i)(j) == 0) {
          queue.enqueue((i, j))
          distances(i)(j) = 0
        }
      }
    }

    while (!queue.isEmpty) {
      val node = queue.dequeue()

      val left = (node._1 - 1, node._2)
      val right = (node._1 + 1, node._2)
      val up = (node._1, node._2 - 1)
      val down = (node._1, node._2 + 1)

      if (isValidPosition(left, rowSize, columnSize) && distances(left._1)(left._2) == -1) {
        distances(left._1)(left._2) = distances(node._1)(node._2) + 1
        queue.enqueue(left)
      }
      if (isValidPosition(right, rowSize, columnSize) && distances(right._1)(right._2) == -1) {
        distances(right._1)(right._2) = distances(node._1)(node._2) + 1
        queue.enqueue(right)
      }
      if (isValidPosition(up, rowSize, columnSize) && distances(up._1)(up._2) == -1) {
        distances(up._1)(up._2) = distances(node._1)(node._2) + 1
        queue.enqueue(up)
      }
      if (isValidPosition(down, rowSize, columnSize) && distances(down._1)(down._2) == -1) {
        distances(down._1)(down._2) = distances(node._1)(node._2) + 1
        queue.enqueue(down)
      }
    }
    distances
  }

  private def isValidPosition(position: (Int, Int), rowSize: Int, columnSize: Int): Boolean =
    if (position._1 < 0 || position._1 >= rowSize || position._2 < 0 || position._2 >= columnSize) {
      false
    } else {
      true
    }
}