package io.icednut.algorithm_exercise.leetcode.q155

import scala.collection.mutable

class MinStack() {

  /** initialize your data structure here. */
  private val stack = new mutable.Stack[(Int, Int)]()

  def push(x: Int): Unit = {
    val newMin: Int = if (stack.isEmpty) {
      x
    } else {
      Math.min(stack.top._2, x)
    }
    stack.push((x, newMin))
  }

  def pop(): Unit = {
    val pop = stack.pop()
  }

  def top(): Int = {
    stack.head._1
  }

  def getMin(): Int = {
    stack.head._2
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
