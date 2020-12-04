package io.icednut.leetcode.exercise.day10.q20

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SolutionTest {

    @Test
    fun `괄호가 제대로 닫혔는지 판단할 수 있어야 한다`() {
        val solution = Solution()
        val result = solution.isValid("()")

        assertTrue(result)
    }

    @Test
    fun `괄호가 제대로 닫혔는지 판단할 수 있어야 한다2`() {
        val solution = Solution()
        val result = solution.isValid("()[]{}")

        assertTrue(result)
    }

    @Test
    fun `괄호가 제대로 닫혔는지 판단할 수 있어야 한다3`() {
        val solution = Solution()
        val result = solution.isValid("(]")

        assertFalse(result)
    }

    @Test
    fun `괄호가 제대로 닫혔는지 판단할 수 있어야 한다4`() {
        val solution = Solution()
        val result = solution.isValid("([)]")

        assertFalse(result)
    }

    @Test
    fun `괄호가 제대로 닫혔는지 판단할 수 있어야 한다5`() {
        val solution = Solution()
        val result = solution.isValid("{[]}")

        assertTrue(result)
    }

    @Test
    fun `괄호가 제대로 닫혔는지 판단할 수 있어야 한다6`() {
        val solution = Solution()
        val result = solution.isValid("{{}[][[[]]]}")

        assertTrue(result)
    }

    @Test
    fun `괄호가 제대로 닫혔는지 판단할 수 있어야 한다7`() {
        val solution = Solution()
        val result = solution.isValid("{{({})}}")

        assertTrue(result)
    }
}