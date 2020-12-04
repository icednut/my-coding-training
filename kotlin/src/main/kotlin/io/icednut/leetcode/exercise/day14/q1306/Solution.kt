package io.icednut.leetcode.exercise.day14.q1306

import java.util.*

class Solution {

    fun canReach(arr: IntArray, start: Int): Boolean {
        val nodes = arr.map { Node(it, false) }
        val queue = LinkedList<Node>()

        val result = visit(queue, nodes, start)
        return result
    }

    fun visit(queue: Queue<Node>, nodes: List<Node>, start: Int): Boolean {
        queue.offer(nodes[start])
        var pastPosition = start
        var frontResult = false
        var backResult = false
        while (queue.isNotEmpty()) {
            val popNode = queue.poll()

            if (popNode.visited) {
                continue
            }
            popNode.visited = true

            if (popNode.data == 0) {
                return true
            }

            if (pastPosition + popNode.data <= nodes.lastIndex) {
                queue.add(nodes[pastPosition + popNode.data])
                backResult = visit(queue, nodes, pastPosition + popNode.data)
            }
            if (pastPosition - popNode.data >= 0) {
                queue.add(nodes[pastPosition - popNode.data])
                frontResult = visit(queue, nodes, pastPosition - popNode.data)
            }
        }
        return frontResult || backResult

    }
}

data class Node(val data: Int, var visited: Boolean)