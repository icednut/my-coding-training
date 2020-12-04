package io.icednut.leetcode.exercise.day09.reorderlinkedlist

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
data class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun reorderList(head: ListNode?): Unit {
        // 정답 1
//        val tempNode = head?.next
//        head?.next = tempNode?.next?.next
//        head?.next?.next = tempNode
//        val tempNode2 = tempNode?.next
//        tempNode2?.next = null

        // 정답 2
//        val tempNode = head?.next
//        head?.next = tempNode?.next?.next?.next
//        head?.next?.next = tempNode
//        val tempNode2 = tempNode?.next
//        head?.next?.next?.next = tempNode2?.next
//        head?.next?.next?.next?.next = tempNode2
//        tempNode2?.next = null

        // 정답 3
//        val tempNode = head?.next
//        head?.next = tempNode?.next?.next?.next?.next
//        head?.next?.next = tempNode
//        val tempNode2 = tempNode?.next
//        head?.next?.next?.next = tempNode2?.next?.next
//        head?.next?.next?.next?.next = tempNode2
//        val tempNode3 = tempNode2?.next
//        tempNode3?.next = null

        // 정답 4
        val tempNode = head?.next
        head?.next = tempNode?.next?.next?.next?.next?.next
        head?.next?.next = tempNode
        val tempNode2 = tempNode?.next
        head?.next?.next?.next = tempNode2?.next?.next?.next
        head?.next?.next?.next?.next = tempNode2
        val tempNode3 = tempNode2?.next?.next
        tempNode3?.next = null
    }
}