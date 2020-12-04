package io.icednut.leetcode.exercise.day00.singlenumber

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SolutionTest {

    @Test
    fun `싱글 넘버를 구할 수 있어야 한다`() {
        val solution = Solution()
        assertEquals(1, solution.singleNumber(intArrayOf(2, 2, 1)))
    }

    @Test
    fun `싱글 넘버를 구할 수 있어야 한다2`() {
        val solution = Solution()
        assertEquals(4, solution.singleNumber(intArrayOf(4,1,2,1,2)))
    }

    @Test
    fun `싱글 넘버를 구할 수 있어야 한다3`() {
        val solution = Solution2()
        assertEquals(1, solution.singleNumber(intArrayOf(2, 2, 1)))
    }

    @Test
    fun `싱글 넘버를 구할 수 있어야 한다4`() {
        val solution = Solution2()
        assertEquals(4, solution.singleNumber(intArrayOf(4,1,2,1,2)))
    }
}