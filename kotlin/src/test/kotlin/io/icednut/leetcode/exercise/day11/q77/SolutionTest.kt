package io.icednut.leetcode.exercise.day11.q77

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SolutionTest {

    @Test
    fun `조합을 구할 수 있어야 한다`() {
        val solution = Solution()
        val combine = solution.combine(4, 2)
        assertEquals(6, combine.size)
    }

    @Test
    fun `조합을 구할 수 있어야 한다2`() {
        val solution = Solution()
        val combine = solution.combine(5, 2)
        assertArrayEquals(intArrayOf(1, 2), combine[0].toIntArray())
        assertArrayEquals(intArrayOf(1, 3), combine[1].toIntArray())
        assertArrayEquals(intArrayOf(1, 4), combine[2].toIntArray())
        assertArrayEquals(intArrayOf(1, 5), combine[3].toIntArray())
        assertArrayEquals(intArrayOf(2, 3), combine[4].toIntArray())
        assertArrayEquals(intArrayOf(2, 4), combine[5].toIntArray())
        assertArrayEquals(intArrayOf(2, 5), combine[6].toIntArray())
        assertArrayEquals(intArrayOf(3, 4), combine[7].toIntArray())
        assertArrayEquals(intArrayOf(3, 5), combine[8].toIntArray())
        assertArrayEquals(intArrayOf(4, 5), combine[9].toIntArray())
        assertEquals(10, combine.size)
    }
}