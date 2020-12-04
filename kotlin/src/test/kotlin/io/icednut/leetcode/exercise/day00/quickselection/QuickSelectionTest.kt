package io.icednut.leetcode.exercise.day00.quickselection

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * @author will.109
 * @date 2020/03/21
 */
internal class QuickSelectionTest {

    @Test
    fun `퀵셀렉션을 할 수 있어야 한다`() {
        val s = QuickSelection()
        assertEquals(5, s.findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
    }

    @Test
    fun `퀵셀렉션을 할 수 있어야 한다2`() {
        val s = QuickSelection()
        assertEquals(4, s.findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
    }

    @Test
    fun `퀵셀렉션을 할 수 있어야 한다3`() {
        val s = QuickSelection()
        assertEquals(1, s.findKthLargest(intArrayOf(1), 1))
    }

    @Test
    fun `퀵셀렉션을 할 수 있어야 한다4`() {
        val s = QuickSelection()
        assertEquals(2, s.findKthLargest(intArrayOf(-1, 2, 0), 1))
    }

    @Test
    fun `퀵셀렉션을 할 수 있어야 한다5`() {
        val s = QuickSelection()
        assertEquals(0, s.findKthLargest(intArrayOf(-1, 2, 0), 2))
    }

    @Test
    fun `퀵셀렉션을 할 수 있어야 한다6`() {
        val s = QuickSelection()
        assertEquals(-1, s.findKthLargest(intArrayOf(-1, 2, 0), 3))
    }
}