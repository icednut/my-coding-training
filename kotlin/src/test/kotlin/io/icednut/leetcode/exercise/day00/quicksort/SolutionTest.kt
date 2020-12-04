package io.icednut.leetcode.exercise.day00.quicksort

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

/**
 * @author will.109
 * @date 2020/03/21
 */
internal class SolutionTest {

    @Test
    fun `퀵소트를 할 수 있어야 한다`() {
        val s = Solution2()
        val originalArray = intArrayOf(3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48)
        val result = s.sortArray(originalArray)
        assertArrayEquals(result.toIntArray(), intArrayOf(2, 3, 4, 5, 15, 19, 26, 27, 36, 38, 44, 46, 47, 48, 50))
    }

    @Test
    fun `퀵소트를 할 수 있어야 한다2`() {
        val s = Solution2()
        val originalArray = intArrayOf(7, 3, 10, 8, 5, 1, 4, 9, 2, 6)
        val result = s.sortArray(originalArray)
        assertArrayEquals(result.toIntArray(), intArrayOf(1,2,3,4,5,6,7,8,9,10))
    }

    @Test
    fun `퀵소트를 할 수 있어야 한다3`() {
        val s = Solution()
        val originalArray = intArrayOf(3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48)
        val result = s.sortArray(originalArray)
        assertArrayEquals(result.toIntArray(), intArrayOf(2, 3, 4, 5, 15, 19, 26, 27, 36, 38, 44, 46, 47, 48, 50))
    }

    @Test
    fun `퀵소트를 할 수 있어야 한다4`() {
        val s = Solution()
        val originalArray = intArrayOf(7, 3, 10, 8, 5, 1, 4, 9, 2, 6)
        val result = s.sortArray(originalArray)
        assertArrayEquals(result.toIntArray(), intArrayOf(1,2,3,4,5,6,7,8,9,10))
    }
}