package io.icednut.leetcode.exercise.day13.q547

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SolutionTest {

    @Test
    fun `friend circle 갯수를 구할수 있어야 한다`() {
        val solution = Solution()
        val N = arrayOf(
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 0, 1)
        )
        assertEquals(2, solution.findCircleNum(N))
    }
}