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

object SolutionPast {
  def numIslands(grid: Array[Array[Char]]): Int = {
    var island = 0
    val stack = new mutable.Stack[Int]()
    stack.push(0)
    var current = stack.pop()
    var visited: Array[Int] = Array()

    // 1
    // current == 0에 근접한 노드를 push 한다.
    if (grid(0)(0) == '1') {
      stack.push(0)
    }
    // 2
    if (grid(0)(1) == '1') {
      stack.push(1)
    }
    // 3
    if (grid(0)(2) == '1') {
      stack.push(2)
    } else {
      visited = visited :+ current // current == 0
      current = stack.pop() // current == 1
    }
    // 4
    // current == 2에 근접한 노드를 push 한다. 근데 방문했으면 push 하지 않는다.
    if (grid(2)(0) == '1') {
      stack.push(???)
    } else {
      visited = visited :+ current // current == 1
      current = stack.pop() // current == 0
    }
    // 5
    // current == 1에 근접한 노드를 push 한다. 근데 방문했으면 push 하지 않는다.
    if (grid(1)(0) == '1') {
      // stack.push(0)
    }
    // 6: 방문 했으므로 push 하지 않음
    if (grid(1)(1) == '1') {
      // stack.push(1)
    }
    // 7
    if (grid(1)(2) == '1') {
      // stack.push(???)
    } else {
      visited = visited :+ current // current == 0
      current = stack.pop() // current == null
    }
    // 8
    if (current == null) {
      island += 1
    }
    // 9
    stack.push(2)
    current = stack.pop() // current == 2
    if (grid(2)(2) == '1') {
      // stack.push(2) 이미 방문함
    }
    // 10
    if (grid(2)(3) == '1') {
      stack.push(???)
    } else {
      visited = visited :+ current // current == 2
      current = stack.pop() // current == null
    }
    // 11
    if (current == null) {
      island += 1
    }
    // 12
    stack.push(3)
    current = stack.pop() // current == 3
    //    if (grid(3)(0) == '1' ) {
    //    if (grid(3)(1) == '1' ) {
    if (grid(3)(3) == '1') {
      // stack.push(3) 이미 방문함
    }
    // ...
    if (grid(3)(4) == '1') {
      stack.push(4)
    }

    current = stack.pop()

    if (current == null) {
      island += 1
    }
    island
  }


  //  def numIslands(grid: Array[Array[Char]]): Int = {
  //    val rowLength = grid.length
  //    var island = 0
  //
  //    for {
  //      i <- 0 until rowLength
  //    } yield {
  //      val blockLength = grid(i).length
  //
  //      for {
  //        j <- 0 until blockLength
  //      } yield {
  //        val block = grid(i)(j)
  //
  //        if (block == '1') {
  //          if (j - 1 < 0 && i - 1 < 0) {
  //            island += 1
  //          } else {
  //            if (j > 0 && i > 0) {
  //              if (grid(i)(j - 1) == '0' && grid(i - 1)(j) == '0') {
  //                island += 1
  //              }
  //            } else if ((j == 0 && j != blockLength - 1) && i == rowLength - 1) {
  //              if (grid(i - 1)(j) == '0' && grid(i)(j + 1) == '0') {
  //                island += 1
  //              }
  //            } else if (j == blockLength - 1 && (i == 0 && i != rowLength - 1)) {
  //              if (grid(i)(j - 1) == '0' && grid(i + 1)(j) == '0') {
  //                island += 1
  //              }
  //            } else if (j == 0 && i > 0) {
  //              if (j + 1 < blockLength) {
  //                if (grid(i - 1)(j) == '0' && grid(i + 1)(j) == '0') {
  //                  island += 1
  //                }
  //              } else {
  //                if (grid(i - 1)(j) == '0') {
  //                  island += 1
  //                }
  //              }
  //            } else if (j > 0 && i == 0) {
  //              if (i + 1 < rowLength) {
  //                if (grid(i)(j - 1) == '0' && grid(i)(j + 1) == '0') {
  //                  island += 1
  //                }
  //              } else {
  //                if (grid(i)(j - 1) == '0') {
  //                  island += 1
  //                }
  //              }
  //            }
  //          }
  //        }
  //      }
  //    }
  //
  //    island
  //  }
}