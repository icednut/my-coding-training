package io.icednut.leetcode.exercise.day14.q1306

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SolutionTest {

    @Test
    fun `점프게임을 할 수 있어야 한다`() {
        val solution = Solution()
        val arr = intArrayOf(4, 2, 3, 0, 3, 1, 2)
        val start = 5

        val result = solution.canReach(arr, start)
        assertEquals(true, result)
    }

    @Test
    fun `점프게임을 할 수 있어야 한다 2`() {
        val solution = Solution()
        val arr = intArrayOf(4, 2, 3, 0, 3, 1, 2)
        val start = 0

        val result = solution.canReach(arr, start)
        assertEquals(true, result)
    }

    @Test
    fun `점프게임을 할 수 있어야 한다 3`() {
        val solution = Solution()
        val arr = intArrayOf(3, 0, 2, 1, 2)
        val start = 2

        val result = solution.canReach(arr, start)
        assertEquals(false, result)
    }

    @Test
    fun `점프게임을 할 수 있어야 한다 4`() {
        val solution = Solution()
        val arr = intArrayOf(4, 4, 1, 3, 0, 3)
        val start = 2

        val result = solution.canReach(arr, start)
        assertEquals(true, result)
    }
}