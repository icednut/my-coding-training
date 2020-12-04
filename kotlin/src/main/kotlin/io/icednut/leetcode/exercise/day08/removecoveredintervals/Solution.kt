package io.icednut.leetcode.exercise.day08.removecoveredintervals

/**
 * @author will.109
 * @date 2020/05/07
 **/
data class Point(val a: Int, val b: Int) : Comparable<Point> {
    override fun compareTo(other: Point): Int {
        if (a < other.a) {
            return -1
        } else if (a == other.a) {
            if (b < other.b) {
                return 1
            } else if (b == other.b) {
                return 0
            } else {
                return -1
            }
        } else {
            return 1
        }
    }
}

class Solution {
    fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
        val sortedIntervals = intervals.map {
            Point(it[0], it[1])
        }.toSortedSet()

        var pastInterval: Point? = null
        var intervalCount = sortedIntervals.size
        for (interval in sortedIntervals) {
            if (pastInterval != null) {
                if (isCovered(pastInterval, interval) || isCovered(interval, pastInterval)) {
                    // covered!!
                    intervalCount -= 1
                } else {
                    pastInterval = interval
                }
            } else {
                pastInterval = interval
            }
        }
        return intervalCount
    }

    private fun isCovered(pointA: Point, pointB: Point): Boolean {
        return pointA.a <= pointB.a && pointB.b <= pointA.b
    }
}