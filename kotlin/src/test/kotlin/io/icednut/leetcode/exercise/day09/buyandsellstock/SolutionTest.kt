package io.icednut.leetcode.exercise.day09.buyandsellstock

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SolutionTest {

    @Test
    fun `가장 수익이 큰 주식 비용을 계산할 수 있어야 한다`() {
        val solution = Solution()

        val maxProfit = solution.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4))

        assertEquals(5, maxProfit)
    }

    @Test
    fun `가장 수익이 큰 주식 비용을 계산할 수 있어야 한다2`() {
        val solution = Solution()

        val maxProfit = solution.maxProfit(intArrayOf(7, 6, 4, 3, 1))

        assertEquals(0, maxProfit)
    }

    @Test
    fun `가장 수익이 큰 주식 비용을 계산할 수 있어야 한다3`() {
        val solution = Solution()

        val maxProfit = solution.maxProfit(intArrayOf(1, 2))

        assertEquals(1, maxProfit)
    }

    @Test
    fun `가장 수익이 큰 주식 비용을 계산할 수 있어야 한다4`() {
        val solution = Solution()

        val maxProfit = solution.maxProfit(intArrayOf(2, 1, 4))

        assertEquals(3, maxProfit)
    }

    @Test
    fun `가장 수익이 큰 주식 비용을 계산할 수 있어야 한다5`() {
        val solution = Solution()

        val maxProfit = solution.maxProfit(intArrayOf(2, 4, 1))

        assertEquals(2, maxProfit)
    }

    @Test
    fun `가장 수익이 큰 주식 비용을 계산할 수 있어야 한다6`() {
        val solution = Solution()
        val maxProfit = solution.maxProfit(intArrayOf(6, 1, 6, 4, 3, 0, 2))

        assertEquals(5, maxProfit)
    }

    @Test
    fun `가장 수익이 큰 주식 비용을 계산할 수 있어야 한다7`() {
        val solution = Solution()

        val maxProfit = solution.maxProfit(intArrayOf(2, 1, 2, 1, 0, 1, 2))

        assertEquals(2, maxProfit)
    }

    @Test
    fun `가장 수익이 큰 주식 비용을 계산할 수 있어야 한다8`() {
        val solution = Solution()

        val maxProfit = solution.maxProfit(intArrayOf(3, 3, 5, 0, 0, 3, 1, 4))

        assertEquals(4, maxProfit)
    }

}