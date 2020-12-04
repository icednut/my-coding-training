package io.icednut.leetcode.exercise.day12.q997

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SolutionTest {

    @Test
    fun `Judge를 찾을 수 있어야 한다1`() {
        val solution = Solution()
        val trust = arrayOf(
            intArrayOf(1, 2)
        )
        assertEquals(2, solution.findJudge(N = 2, trust = trust))
    }

    @Test
    fun `Judge를 찾을 수 있어야 한다2`() {
        val solution = Solution()
        val trust = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 3)
        )
        assertEquals(3, solution.findJudge(N = 3, trust = trust))
    }

    @Test
    fun `Judge를 찾을 수 있어야 한다3`() {
        val solution = Solution()
        val trust = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 3),
            intArrayOf(3, 1)
        )
        assertEquals(-1, solution.findJudge(N = 3, trust = trust))
    }

    @Test
    fun `Judge를 찾을 수 있어야 한다4`() {
        val solution = Solution()
        val trust = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3)
        )
        assertEquals(-1, solution.findJudge(N = 3, trust = trust))
    }

    @Test
    fun `Judge를 찾을 수 있어야 한다5`() {
        val solution = Solution()
        val trust = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(1, 4),
            intArrayOf(2, 3),
            intArrayOf(2, 4),
            intArrayOf(4, 3)
        )
        assertEquals(3, solution.findJudge(N = 4, trust = trust))
    }
}