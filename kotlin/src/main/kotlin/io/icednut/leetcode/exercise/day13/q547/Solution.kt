package io.icednut.leetcode.exercise.day13.q547

import java.util.*

class Solution {
    fun findCircleNum(M: Array<IntArray>): Int {
        val stack = Stack<Int>()
        var answer = 0
        val visited = Array(M.size) { false }

        for (i in 0..M.lastIndex) {
            if (!visited[i]) {
                stack.push(i)
                answer += 1
                while (!stack.isEmpty()) {
                    val currentNode = stack.pop()
                    visited[currentNode] = true

                    for (j in 0..M[currentNode].lastIndex) {
                        if (!visited[j] && M[currentNode][j] == 1) {
                            stack.push(j)
                        }
                    }
                }
            }
        }
        return answer
    }
}