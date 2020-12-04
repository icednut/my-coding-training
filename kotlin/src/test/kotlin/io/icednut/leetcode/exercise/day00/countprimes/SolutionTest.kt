package io.icednut.leetcode.exercise.day00.countprimes

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * @author will.109
 * @date 2020/03/28
 */
internal class SolutionTest {

    @Test
    fun `소수를 구할 수 있어야 한다`() {
        val solution = Solution2()
        assertEquals(4, solution.countPrimes(10))
    }

    @Test
    fun `소수를 구할 수 있어야 한다2`() {
        val solution = Solution2()
        assertEquals(30, solution.countPrimes(120))
    }

    @Test
    fun `소수를 구할 수 있어야 한다3`() {
        val solution = Solution2()
        assertEquals(0, solution.countPrimes(2))
    }

    @Test
    fun `소수를 구할 수 있어야 한다4`() {
        val solution = Solution2()
        assertEquals(46, solution.countPrimes(210))
    }

    @Test
    fun `소수를 구할 수 있어야 한다5`() {
        val solution = Solution2()
        assertEquals(1229, solution.countPrimes(10000))
    }

    @Test
    fun `소수를 구할 수 있어야 한다6`() {
        val solution = Solution2()
        assertEquals(41537, solution.countPrimes(499979))
    }

    @Test
    fun `소수를 구할 수 있어야 한다7`() {
        val solution = Solution2()
        assertEquals(78497, solution.countPrimes(999983))
    }
}