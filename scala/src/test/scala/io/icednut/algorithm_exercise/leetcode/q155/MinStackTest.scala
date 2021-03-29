package io.icednut.algorithm_exercise.leetcode.q155

import org.scalatest.funsuite.AnyFunSuite

class MinStackTest extends AnyFunSuite {

  test("case 01") {
    val minStack = new MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    assert(minStack.getMin == -3)

    minStack.pop
    assert(minStack.top == 0)

    assert(minStack.getMin == -2)
  }
}
