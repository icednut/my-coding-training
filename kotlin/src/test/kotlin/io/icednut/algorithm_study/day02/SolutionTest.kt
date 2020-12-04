package io.icednut.algorithm_study.day02

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SolutionTest {

    @Test
    fun test_pattern() {
        val solution = Solution()

        assertEquals(true, solution.wordPattern("abba", "dog cat cat dog"))
        assertEquals(false, solution.wordPattern("abba", "dog cat cat fish"))
        assertEquals(false, solution.wordPattern("aaaa", "dog cat cat dog"))
        assertEquals(false, solution.wordPattern("abba", "dog dog dog dog"))
    }
}