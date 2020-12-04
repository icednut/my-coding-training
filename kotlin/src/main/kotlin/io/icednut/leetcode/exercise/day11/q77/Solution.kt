package io.icednut.leetcode.exercise.day11.q77

class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val answer = mutableListOf<MutableList<Int>>()

        go(answer, mutableListOf(), k, n, 1)
        return answer
    }

    private fun go(
        answer: MutableList<MutableList<Int>>,
        currentAnswer: MutableList<Int>,
        k: Int,
        n: Int,
        startIndex: Int
    ) {
        if (k == 0) {
            answer.add(currentAnswer.toMutableList())
            return
        }
        for (i in startIndex..n) {
            currentAnswer.add(i)
            go(answer, currentAnswer, k - 1, n, i + 1)
            currentAnswer.removeAt(currentAnswer.lastIndex)
        }
    }
}