package io.icednut.leetcode.exercise.day09.generics.contravariance3

import io.icednut.leetcode.exercise.day09.generics.contravariance2.Bird
import io.icednut.leetcode.exercise.day09.generics.contravariance2.Duck
import org.junit.jupiter.api.Test

internal class ContravarianceTest {

    @Test
    fun `책에 나온 반공변 예제 돌려보기`() {
        val strings: List<Int> = listOf(1, 2, 3)

        val anyComparator: Comparator<Any> = Comparator<Any> { e1, e2 ->
            e1.hashCode() - e2.hashCode()
        }
//        val anyComparator: Comparator<Any> = object : Comparator<Any> {
//            override fun compare(e1: Any, e2: Any): Int {
//                return e1.hashCode() - e2.hashCode()
//            }
//        }

        val result: List<Number> = strings.sortedWith(anyComparator)
    }

    @Test
    fun `반공변의 이해 - 예제3`() {
        val elements: List<Bird> = listOf()

        val anyComparator = Comparator<Duck> { e1, e2 ->
            e1.hashCode() - e2.hashCode()
        }

//        val result = elements.sortedWith(anyComparator)
    }
}
