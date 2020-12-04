package io.icednut.leetcode.exercise.day08.typeerasure

import org.junit.jupiter.api.Test

/**
 * @author will.109
 * @date 2020/05/12
 */
internal class ExerciseKtTest {

    @Test
    fun `test Type Erasure`() {
        printSum(listOf(1, 2, 3))
        printSum(listOf("A", "B", "C"))
    }
}