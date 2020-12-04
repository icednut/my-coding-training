package io.icednut.leetcode.exercise.day07

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

/**
 * @author will.109
 * @date 2020/04/27
 */
internal class RedundantConnectionTest {

    @Test
    fun `트리가 만들어지지 않는 간선을 찾아내라`() {
        val solution = RedundantConnectionSolution()

        val result =
            solution.findRedundantConnection(arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 3)))

        assertArrayEquals(result, intArrayOf(2, 3))
    }
}