package io.icednut.leetcode.exercise.day10.q20

import java.util.*

class Solution {
    val answerMap = mapOf('(' to ')', '{' to '}', '[' to ']')

    fun isValid(s: String): Boolean {
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
        return stack.isEmpty()
    }
}