package io.icednut.algorithm_exercise.leetcode.q86

/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
  def partition(head: ListNode, x: Int): ListNode = {
    def run(head: ListNode, x: Int): ListNode = {
      if (head.x > x) {
        return head
      }

      head.x = head.next.x
      head
    }
    run(head.next, x)
  }
}


class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}