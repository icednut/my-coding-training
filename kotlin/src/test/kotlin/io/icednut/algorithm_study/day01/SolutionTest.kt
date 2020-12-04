package io.icednut.algorithm_study.day01

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SolutionTest {

    @Test
    fun test_largestNumber() {
        val solution = Solution()

        assertEquals("210", solution.largestNumber(intArrayOf(10, 2)))
        assertEquals("9534330", solution.largestNumber(intArrayOf(3, 30, 34, 5, 9)))
        assertEquals("1", solution.largestNumber(intArrayOf(1)))
        assertEquals("10", solution.largestNumber(intArrayOf(10)))
        assertEquals("43243432", solution.largestNumber(intArrayOf(432, 43243)))
        assertEquals("0", solution.largestNumber(intArrayOf(0, 0)))
        assertEquals("0", solution.largestNumber(intArrayOf(0, 0, 0)))
        assertEquals("1113111311", solution.largestNumber(intArrayOf(111311, 1113)))
        assertEquals("93921710", solution.largestNumber(intArrayOf(10, 2, 9, 39, 17)))
        assertEquals("12121", solution.largestNumber(intArrayOf(12, 121)))
        assertEquals("999999999999999998999999997", solution.largestNumber(intArrayOf(999999998, 999999997, 999999999)))
    }
}