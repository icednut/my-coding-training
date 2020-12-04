package io.icednut.leetcode.exercise.day00.searchinsertposition

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * @author will.109
 * @date 2020/03/29
 */
internal class Solution2Test {

    @Test
    fun `바이너리 서치를 할 수 있어야 한다`() {
        val solution = Solution2()
        val target = intArrayOf(1, 3, 5, 6)

        assertEquals(2, solution.searchInsert(target, 5))
    }

    @Test
    fun `바이너리 서치를 할 수 있어야 한다2`() {
        val solution = Solution2()
        val target = intArrayOf(1, 3, 5, 6)

        assertEquals(1, solution.searchInsert(target, 2))
    }

    @Test
    fun `바이너리 서치를 할 수 있어야 한다3`() {
        val solution = Solution2()
        val target = intArrayOf(1, 3, 5, 6)

        assertEquals(4, solution.searchInsert(target, 7))
    }

    @Test
    fun `바이너리 서치를 할 수 있어야 한다4`() {
        val solution = Solution2()
        val target = intArrayOf(1, 3, 5, 6)

        assertEquals(0, solution.searchInsert(target, 0))
    }

    @Test
    fun `바이너리 서치를 할 수 있어야 한다5`() {
        val solution = Solution2()
        val target = intArrayOf(1)

        assertEquals(0, solution.searchInsert(target, 0))
    }

    @Test
    fun `바이너리 서치를 할 수 있어야 한다6`() {
        val solution = Solution2()
        val target = intArrayOf(1)

        assertEquals(1, solution.searchInsert(target, 2))
    }

    @Test
    fun `바이너리 서치를 할 수 있어야 한다7`() {
        val solution = Solution2()
        val target = intArrayOf(1)

        assertEquals(0, solution.searchInsert(target, 1))
    }

    @Test
    fun `바이너리 서치를 할 수 있어야 한다8`() {
        val solution = Solution2()
        val target = intArrayOf(1, 3)

        assertEquals(1, solution.searchInsert(target, 3))
    }

    @Test
    fun `바이너리 서치를 할 수 있어야 한다9`() {
        val solution = Solution2()
        val target = intArrayOf(1, 4, 6, 7, 8, 9)

        assertEquals(2, solution.searchInsert(target, 6))
    }

    @Test
    fun `바이너리 서치를 할 수 있어야 한다10`() {
        val solution = Solution2()
        val target = intArrayOf(1, 3)

        assertEquals(0, solution.searchInsert(target, 0))
    }
}