package io.icednut.leetcode.exercise.day10.q300

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SolutionTest {

    @Test
    fun `가장긴 LIS를 구할 수 있어야 한다`() {
        val given = intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)
        val solution = Solution()

        val lengthOfLIS = solution.lengthOfLIS(given)

        assertEquals(4, lengthOfLIS)
    }

    @Test
    fun `가장긴 LIS를 구할 수 있어야 한다2`() {
        val given = intArrayOf(0)
        val solution = Solution()

        val lengthOfLIS = solution.lengthOfLIS(given)

        assertEquals(1, lengthOfLIS)
    }

    @Test
    fun `가장긴 LIS를 구할 수 있어야 한다3`() {
        val given = intArrayOf()
        val solution = Solution()

        val lengthOfLIS = solution.lengthOfLIS(given)

        assertEquals(0, lengthOfLIS)
    }

    @Test
    fun `가장긴 LIS를 구할 수 있어야 한다4`() {
        val given = intArrayOf(10, 9, 2, 5, 3, 4)
        val solution = Solution()

        val lengthOfLIS = solution.lengthOfLIS(given)

        assertEquals(3, lengthOfLIS)
    }

    @Test
    fun `가장긴 LIS를 구할 수 있어야 한다5`() {
        val given = intArrayOf(2, 2)
        val solution = Solution()

        val lengthOfLIS = solution.lengthOfLIS(given)

        assertEquals(1, lengthOfLIS)
    }

    @Test
    fun `가장긴 LIS를 구할 수 있어야 한다6`() {
        val given = intArrayOf(1, 3, 6, 7, 9, 4, 10, 5, 6)
        val solution = Solution()

        val lengthOfLIS = solution.lengthOfLIS(given)

        assertEquals(6, lengthOfLIS)
    }

    @Test
    fun `가장긴 LIS를 구할 수 있어야 한다7`() {
        val given = intArrayOf(10, 22, 9, 33, 21, 50, 41, 60, 80)
        val solution = Solution()

        val lengthOfLIS = solution.lengthOfLIS(given)

        assertEquals(6, lengthOfLIS)
    }
}