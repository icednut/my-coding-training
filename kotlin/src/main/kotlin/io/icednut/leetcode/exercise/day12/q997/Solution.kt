package io.icednut.leetcode.exercise.day12.q997

class Solution {
    fun findJudge(N: Int, trust: Array<IntArray>): Int {
        val count = Array(N + 1) { 0 }
        for (t in trust) {
            count[t[0]] -= 1
            count[t[1]] += 1
        }

        for (i in 1..N) {
            if (count[i] == N - 1) {
                return i
            }
        }
        return -1
    }
}