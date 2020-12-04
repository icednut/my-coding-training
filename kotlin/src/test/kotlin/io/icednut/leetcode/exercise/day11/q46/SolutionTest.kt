package io.icednut.leetcode.exercise.day11.q46

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

internal class SolutionTest {

    @Test
    fun `모든 순열을 구할 수 있어야 한다`() {
        val solution = Solution()

        val result = solution.permute(intArrayOf(1, 2, 3))
        assertArrayEquals(intArrayOf(1, 2, 3), result[0].toIntArray())
        assertArrayEquals(intArrayOf(1, 3, 2), result[1].toIntArray())
        assertArrayEquals(intArrayOf(2, 1, 3), result[2].toIntArray())
        assertArrayEquals(intArrayOf(2, 3, 1), result[3].toIntArray())
        assertArrayEquals(intArrayOf(3, 1, 2), result[4].toIntArray())
        assertArrayEquals(intArrayOf(3, 2, 1), result[5].toIntArray())
    }
}