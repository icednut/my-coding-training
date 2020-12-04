package io.icednut.leetcode.exercise.day11.q46

class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        go(nums, result, mutableListOf<Int>(), Array(nums.size) { false })
        return result
    }

    private fun go(
        nums: IntArray,
        answer: MutableList<List<Int>>,
        currentAnswer: MutableList<Int>,
        visited: Array<Boolean>
    ) {
        if (currentAnswer.size == nums.size) {
            answer.add(currentAnswer.toList())
            return
        }

        for (i in 0..nums.lastIndex) {
            if (visited[i]) {
                continue
            }
            currentAnswer.add(nums[i])
            visited[i] = true
            go(nums, answer, currentAnswer, visited)
            visited[i] = false
            currentAnswer.removeAt(currentAnswer.lastIndex)
        }
    }
}