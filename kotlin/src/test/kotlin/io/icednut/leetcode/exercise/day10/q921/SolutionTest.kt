package io.icednut.leetcode.exercise.day10.q921

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SolutionTest {

    @Test
    fun `안닫힌 괄호의 개수를 구해야 한다`() {
        val solution = Solution()
        val count = solution.minAddToMakeValid("())")

        assertEquals(1, count)
    }

    @Test
    fun `안닫힌 괄호의 개수를 구해야 한다2`() {
        val solution = Solution()
        val count = solution.minAddToMakeValid("(((")

        assertEquals(3, count)
    }

    @Test
    fun `안닫힌 괄호의 개수를 구해야 한다3`() {
        val solution = Solution()
        val count = solution.minAddToMakeValid("()")

        assertEquals(0, count)
    }

    @Test
    fun `안닫힌 괄호의 개수를 구해야 한다4`() {
        val solution = Solution()
        val count = solution.minAddToMakeValid("()))((")

        assertEquals(4, count)
    }
}