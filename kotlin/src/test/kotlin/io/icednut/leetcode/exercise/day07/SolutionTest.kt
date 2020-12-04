package io.icednut.leetcode.exercise.day07

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * @author will.109
 * @date 2020/04/27
 */
internal class SolutionTest {

    @Test
    fun `가장 큰 둘레를 갖는 삼각형의 둘레를 구하시오 1`() {
        val solution = Solution()

        assertEquals(solution.largestPerimeter(intArrayOf(2,1,2)), 5)
    }

    @Test
    fun `가장 큰 둘레를 구하시오 2`() {
        val solution = Solution()

        assertEquals(solution.largestPerimeter(intArrayOf(1,2,1)), 0)
    }

    @Test
    fun `가장 큰 둘레를 구하시오 3`() {
        val solution = Solution()

        assertEquals(solution.largestPerimeter(intArrayOf(3,2,3,4)), 10)
    }

    @Test
    fun `가장 큰 둘레를 구하시오 4`() {
        val solution = Solution()

        assertEquals(solution.largestPerimeter(intArrayOf(3,6,2,3)), 8)
    }
}