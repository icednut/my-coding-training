package io.icednut.leetcode.exercise.day10.q921

import java.util.*

class Solution {
    val answerMap = mapOf('(' to ')', '{' to '}', '[' to ']')

    fun minAddToMakeValid(s: String): Int {
        val prase = s.toCharArray()
        val stack = Stack<Char>()

        for (c in prase) {
            if (stack.isEmpty()) {
                stack.push(c)
                continue
            }

            if (answerMap[stack.peek()] != c) {
                stack.push(c)
            } else {
                stack.pop()
            }
        }
        return stack.size
    }
}