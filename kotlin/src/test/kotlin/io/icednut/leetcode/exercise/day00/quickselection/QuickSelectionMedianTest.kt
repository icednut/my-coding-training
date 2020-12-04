package io.icednut.leetcode.exercise.day00.quickselection

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * @author will.109
 * @date 2020/03/24
 */
internal class QuickSelectionMedianTest {

    @Test
    fun `퀵셀렉션을 할 수 있어야 한다`() {
        val s = QuickSelectionWithMedian()
        assertEquals(5, s.findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
    }

    @Test
    fun `퀵셀렉션을 할 수 있어야 한다2`() {
        val s = QuickSelectionWithMedian()
        assertEquals(4, s.findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
    }

    @Test
    fun `퀵셀렉션을 할 수 있어야 한다3`() {
        val s = QuickSelectionWithMedian()
        assertEquals(1, s.findKthLargest(intArrayOf(1), 1))
    }

    @Test
    fun `퀵셀렉션을 할 수 있어야 한다4`() {
        val s = QuickSelectionWithMedian()
        assertEquals(2, s.findKthLargest(intArrayOf(-1, 2, 0), 1))
    }

    @Test
    fun `퀵셀렉션을 할 수 있어야 한다5`() {
        val s = QuickSelectionWithMedian()
        assertEquals(0, s.findKthLargest(intArrayOf(-1, 2, 0), 2))
    }

    @Test
    fun `퀵셀렉션을 할 수 있어야 한다6`() {
        val s = QuickSelectionWithMedian()
        assertEquals(-1, s.findKthLargest(intArrayOf(-1, 2, 0), 3))
    }

    @Test
    fun `퀵셀렉션을 할 수 있어야 한다7`() {
        val s = QuickSelectionWithMedian()
        assertEquals(48, s.findKthLargest(intArrayOf(3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48), 2))
    }

    @Test
    fun `퀵셀렉션을 할 수 있어야 한다8`() {
        val s = QuickSelectionWithMedian()
        assertEquals(6, s.findKthLargest(intArrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1), 5))
    }
}