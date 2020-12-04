package io.icednut.leetcode.exercise.day09.generics.common

import org.junit.jupiter.api.Test

internal class GenericsTest {

    @Test
    fun `List Any 실험하기`() {
        val strings = mutableListOf("abc", "bac")
//        addAnswer(strings)
        strings.maxBy { it.length }
    }

    fun addAnswer(list: MutableList<Any>) {
        list.add(42)
    }

    @Test
    fun `List Any 실험하기2`() {
        val strings = listOf("abc", "bac")
        printContents(strings)
    }

    fun printContents(list: List<Any>) {
        println(list.joinToString())
    }
}