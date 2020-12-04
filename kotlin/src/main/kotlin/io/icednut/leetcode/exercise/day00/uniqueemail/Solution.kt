package io.icednut.leetcode.exercise.day00.uniqueemail

/**
 * @author will.109
 * @date 2020/03/23
 **/
class Solution {

    fun numUniqueEmails(emails: Array<String>): Int {
        return emails
            .map {
                val emailAddress = it.split("@")
                val nickname = emailAddress[0]
                val domain = emailAddress[1]

                val actualNickname = replaceActualString(nickname.replace(".", ""))
                val actualDomain =
                    replaceActualString(domain.substringBeforeLast(".")) + "." + domain.substringAfterLast(".")

                "$actualNickname@$actualDomain"
            }
            .toSet()
            .size
    }

    private fun replaceActualString(targetString: String): String {
        return targetString.substringBefore("+")
    }
}