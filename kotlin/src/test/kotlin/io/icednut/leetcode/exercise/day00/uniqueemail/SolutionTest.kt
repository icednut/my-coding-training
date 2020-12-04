package io.icednut.leetcode.exercise.day00.uniqueemail

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * @author will.109
 * @date 2020/03/23
 */
internal class SolutionTest {
    @Test
    fun test() {
        val s = Solution()
        val count = s.numUniqueEmails(
            arrayOf(
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
            )
        )
        assertEquals(2, count)
    }
}