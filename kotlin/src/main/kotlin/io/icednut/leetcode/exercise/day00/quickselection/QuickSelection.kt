package io.icednut.leetcode.exercise.day00.quickselection

/**
 * @author will.109
 * @date 2020/03/24
 **/
class QuickSelection {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        fun swap(numList: MutableList<Int>, first: Int, next: Int) {
            val temp = numList[first]
            numList[first] = numList[next]
            numList[next] = temp
        }

        fun partition(numList: MutableList<Int>, leftIndex: Int, rightIndex: Int): Int {
            if (leftIndex == rightIndex) {
                return leftIndex
            }
            val pivotIndex = leftIndex
            val pivot = numList[pivotIndex]
            var st = leftIndex + 1

            for (i in (pivotIndex + 1)..rightIndex) {
                if (pivot > numList[i]) {
                    swap(numList, st, i)
                    st++
                }
            }
            swap(numList, pivotIndex, st - 1)
            return st
        }

        fun quickSelection(
            numList: MutableList<Int>,
            leftIndex: Int,
            rightIndex: Int,
            k: Int
        ): Int {
            val newPivot = partition(numList, leftIndex, rightIndex)

            if (newPivot == k && leftIndex == rightIndex) {
                return numList[k]
            } else if (newPivot > k) {
                return quickSelection(numList, leftIndex, newPivot - 1, k)
            } else {
                return quickSelection(numList, newPivot, rightIndex, k)
            }
        }

        val numList = nums.toMutableList()
        return quickSelection(numList, 0, numList.lastIndex, numList.lastIndex - (k - 1))
    }
}