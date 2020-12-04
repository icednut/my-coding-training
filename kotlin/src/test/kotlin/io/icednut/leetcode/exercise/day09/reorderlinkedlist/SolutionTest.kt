package io.icednut.leetcode.exercise.day09.reorderlinkedlist

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class SolutionTest {

    @Test
    @Disabled
    fun `링크드 리스트를 재정렬 할 수 있어야 한다`() {
        val solution = Solution()

        val node1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(4)
        node1.next = node2
        node2.next = node3
        node3.next = node4

        solution.reorderList(node1)

        var targetNode: ListNode? = node1
        for (value in intArrayOf(1, 4, 2, 3)) {
            assertEquals(value, targetNode?.`val`)
            targetNode = targetNode?.next
        }
    }

    @Test
    @Disabled
    fun `링크드 리스트를 재정렬 할 수 있어야 한다2`() {
        val solution = Solution()

        val node1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(4)
        val node5 = ListNode(5)
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5

        solution.reorderList(node1)

        var targetNode: ListNode? = node1
        for (value in intArrayOf(1, 5, 2, 4, 3)) {
            assertEquals(value, targetNode?.`val`)
            targetNode = targetNode?.next
        }
    }

    @Test
    @Disabled
    fun `링크드 리스트를 재정렬 할 수 있어야 한다3`() {
        val solution = Solution()

        val node1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(4)
        val node5 = ListNode(5)
        val node6 = ListNode(6)
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = node6

        solution.reorderList(node1)

        var targetNode: ListNode? = node1
        for (value in intArrayOf(1, 6, 2, 5, 3, 4)) {
            assertEquals(value, targetNode?.`val`)
            targetNode = targetNode?.next
        }
    }

    @Test
    fun `링크드 리스트를 재정렬 할 수 있어야 한다4`() {
        val solution = Solution()

        val node1 = ListNode(1)
        val node2 = ListNode(2)
        val node3 = ListNode(3)
        val node4 = ListNode(4)
        val node5 = ListNode(5)
        val node6 = ListNode(6)
        val node7 = ListNode(7)
        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = node6
        node6.next = node7

        solution.reorderList(node1)

        var targetNode: ListNode? = node1
        for (value in intArrayOf(1, 7, 2, 6, 3, 5, 4)) {
            assertEquals(value, targetNode?.`val`)
            targetNode = targetNode?.next
        }
    }
}