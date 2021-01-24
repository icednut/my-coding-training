package io.icednut.algorithm_exercise.leetcode.q86

import org.scalatest.funsuite.AnyFunSuite

class SolutionTest extends AnyFunSuite {

  test("case 01") {
    val head = new ListNode(1,
      new ListNode(4,
        new ListNode(3,
          new ListNode(2,
            new ListNode(5,
              new ListNode(2, null))))))
    val x = 3

    val actualResult = Solution.partition(head, x)
    assert(actualResult == new ListNode(1,
      new ListNode(2,
        new ListNode(2,
          new ListNode(4,
            new ListNode(3,
              new ListNode(5, null)))))))
  }
}
