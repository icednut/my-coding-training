package io.icednut.leetcode.exercise.day00.singlenumberii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * @author will.109
 * @date 2020/04/05
 */
internal class SolutionTest {

    @Test
    fun `싱글 넘버를 찾을 수 있어야 한다`() {
        val solution = Solution()
        assertEquals(3, solution.singleNumber(intArrayOf(2, 2, 3, 2)))
    }
}