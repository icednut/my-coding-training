package io.icednut.leetcode.exercise.day00.quickselection

/**
 * @author will.109
 * @date 2020/03/24
 **/
class QuickSelection2 {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        fun swap(numList: MutableList<Int>, first: Int, next: Int) {
            val temp = numList[first]
            numList[first] = numList[next]
            numList[next] = temp
        }

        fun partition(numList: MutableList<Int>, leftIndex: Int, rightIndex: Int): Int {
            val pivotIndex = leftIndex
            val pivot = numList[pivotIndex]
            var l = leftIndex + 1
            var r = rightIndex

            while (l <= r) {
                if (numList[l] > pivot && numList[r] < pivot) {
                    swap(numList, l, r)
                    l++
                    r--
                }
                if (numList[l] <= pivot) {
                    l++
                }
                if (numList[r] >= pivot) {
                    r--
                }
            }
            swap(numList, pivotIndex, l - 1)
            return l - 1
        }

        fun quickSelection(
            numList: MutableList<Int>,
            leftIndex: Int,
            rightIndex: Int,
            k: Int
        ): Int {
            val newPivot = partition(numList, leftIndex, rightIndex)

            if (newPivot == k) {
                return numList[k]
            } else if (newPivot > k) {
                return quickSelection(numList, leftIndex, newPivot - 1, k)
            } else {
                return quickSelection(numList, newPivot + 1, rightIndex, k)
            }
        }

        val numList = nums.toMutableList()
        return quickSelection(numList, 0, numList.lastIndex, numList.lastIndex - (k - 1))
    }
}