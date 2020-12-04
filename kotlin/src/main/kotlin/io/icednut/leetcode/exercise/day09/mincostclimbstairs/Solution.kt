package io.icednut.leetcode.exercise.day09.mincostclimbstairs

class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {

        val cache = Array(cost.size + 1) { Array(cost.size + 2) { -1 } }

        // 메모이제이션 해야함
        fun go(cost: IntArray, pastPosition: Int): Int {
            if (pastPosition == cost.lastIndex) {
                return cost[pastPosition]
            }
            if (pastPosition > cost.lastIndex) {
                return 0
            }

            var result: Int
            if (cache[pastPosition + 1][pastPosition + 2] == -1) {
                result = Math.min(
                    go(cost, pastPosition + 1),
                    go(cost, pastPosition + 2)
                )
                cache[pastPosition + 1][pastPosition + 2] = result
            } else {
                result = cache[pastPosition + 1][pastPosition + 2]
            }
            return (if (pastPosition < 0) 0 else cost[pastPosition]) + result
        }

        return go(cost, -1)
    }
}