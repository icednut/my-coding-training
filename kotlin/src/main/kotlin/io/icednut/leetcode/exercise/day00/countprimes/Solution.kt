package io.icednut.leetcode.exercise.day00.countprimes

import kotlin.math.sqrt

class Solution {
    fun countPrimes(n: Int): Int {
        val sequence = generateSequence(0) { it + 1 }.take(n).drop(2)
        val compositeNumberMap = mutableMapOf<Int, Boolean>()

        return sequence.filter { num ->
            if (compositeNumberMap[num] == true) {
                false
            } else {
                val sqrt = sqrt(n.toDouble()).toInt()
                if (num <= sqrt) {
                    val find = generateSequence(num) { if (it < n) it + 1 else null }
                        .filter { it <= n }
                        .filter { it % num == 0 }
                        .map { it to true }
                        .toMap()
                    compositeNumberMap.putAll(find)
                }
                true
            }
        }.count()
    }
}

class Solution2 {
    fun countPrimes(n: Int): Int {
        if (n < 2) {
            return 0
        }

        val isComposite = generateSequence(0) { if (it < n - 1) it + 1 else null }
            .map { if (it < 2) true else false }
            .toMutableList()

        var i = 0
        while (true) {
            if (i * i > n) {
                break
            }

            if (!isComposite[i]) {
                var j = i * i
                while (true) {
                    if (j >= n) {
                        break
                    }
                    isComposite[j] = true
                    j += i
                }
            }
            i++
        }

        val count = isComposite.filter { !it }.count()
        return count
    }
}