package io.icednut.leetcode.exercise.day09.buyandsellstock

import kotlin.math.max

class Solution {
    fun maxProfit(prices: IntArray): Int {
        fun go(index: Int, maxIndex: Int): Int {
            if (index > prices.lastIndex) {
                return 0
            }

            val maxValuePair = getMaxPrice(prices, index, maxIndex)
            val maxValueIndex = maxValuePair.first ?: 0
            return max(maxValuePair.second, go(index + 1, maxValueIndex))
        }

        var maxCostIndex = getMaxCostIndex(prices, -1)
        var minCostIndex = getMinCostIndex(prices, -1, prices.lastIndex)

        if (maxCostIndex < minCostIndex) {
            if (minCostIndex == prices.lastIndex) {
                minCostIndex = getMinCostIndex(prices, -1, maxCostIndex)
            } else {
                maxCostIndex = getMaxCostIndex(prices, minCostIndex)
            }
        }
        return go(minCostIndex, maxCostIndex)
    }

    private fun getMaxPrice(prices: IntArray, index: Int, maxIndex: Int): Pair<Int?, Int> {
        val maxCost = prices[maxIndex]
        val maxPrice = if (index < maxIndex) maxCost - prices[index] else 0
        return Pair(maxIndex, maxPrice)
    }

    private fun getMinCostIndex(prices: IntArray, startIndex: Int, lastIndex: Int): Int {
        val minCost = prices
            .mapIndexed { idx, value -> Pair(idx, value) }
            .minWith(Comparator { o1, o2 ->
                if (o1.first <= startIndex || o2.first >= lastIndex) { // TODO: 마지막 인덱스는 비교 안하도록 수정해야 됨
                    1
                } else {
                    when {
                        o1.second > o2.second -> 1
                        o1.second == o2.second -> 0
                        else -> -1
                    }
                }
            })
        return minCost?.first ?: 0
    }

    fun getMaxCostIndex(prices: IntArray, index: Int): Int {
        val maxCost = prices
            .mapIndexed { idx, value -> Pair(idx, value) }
            .maxWith(Comparator { o1, o2 ->
                if (o1.first <= index) {
                    -1
                } else {
                    when {
                        o1.second > o2.second -> 1
                        o1.second == o2.second -> 0
                        else -> -1
                    }
                }
            })
        return prices.lastIndexOf(maxCost?.second ?: 0)
    }
}