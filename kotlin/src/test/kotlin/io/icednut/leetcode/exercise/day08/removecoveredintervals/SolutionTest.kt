package io.icednut.leetcode.exercise.day08.removecoveredintervals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * @author will.109
 * @date 2020/05/07
 */
internal class SolutionTest {

    @Test
    fun `겹치는 포인트를 제거해야 한다`() {
        val solution = Solution()
        val givenArray = arrayOf(intArrayOf(1, 4), intArrayOf(3, 6), intArrayOf(2, 8))

        val output = solution.removeCoveredIntervals(givenArray)
        assertEquals(output, 2)
    }

    @Test
    fun `겹치는 포인트를 제거해야 한다2`() {
        val solution = Solution()
        val givenArray = arrayOf(intArrayOf(1, 2), intArrayOf(1, 4), intArrayOf(3, 4))

        val output = solution.removeCoveredIntervals(givenArray)
        assertEquals(output, 1)
    }

    /**
     * [[],[],[],[],[],[],[]]
     */
    @Test
    fun `겹치는 포인트를 제거해야 한다3`() {
        val solution = Solution()
        val givenArray = arrayOf(intArrayOf(66672,75156), intArrayOf(59890,65654), intArrayOf(92950,95965), intArrayOf(9103,31953), intArrayOf(54869,69855), intArrayOf(33272,92693), intArrayOf(52631,65356), intArrayOf(43332,89722), intArrayOf(4218,57729), intArrayOf(20993,92876))

        val output = solution.removeCoveredIntervals(givenArray)
        assertEquals(3, output)
    }
}