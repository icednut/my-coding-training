package io.icednut.leetcode.exercise.day00.quicksort

/**
 * @author will.109
 * @date 2020/03/19
 **/
class Solution {
    fun sortArray(nums: IntArray): List<Int> {
        fun swap(targetArray: MutableList<Int>, index1: Int, index2: Int) {
            val temp = targetArray[index2]
            targetArray.set(index2, targetArray[index1])
            targetArray.set(index1, temp)
        }

        fun partition(targetList: MutableList<Int>, leftIndex: Int, rightIndex: Int): Int {
            val pivotIndex = leftIndex
            var storeIndex = pivotIndex + 1

            val pivot = targetList.get(pivotIndex)
            for (i in (pivotIndex + 1)..rightIndex) {
                val targetValue = targetList.get(i)
                if (pivot > targetValue) {
                    swap(targetList, storeIndex, i)
                    storeIndex++
                }
            }
            swap(targetList, pivotIndex, storeIndex - 1)
            return storeIndex
        }

        fun sort(targetList: MutableList<Int>, leftIndex: Int, rightIndex: Int) {
            if (leftIndex == rightIndex || leftIndex > targetList.lastIndex) {
                return
            }

            var newPivot = partition(targetList, leftIndex, rightIndex)
            sort(targetList, leftIndex, newPivot - 1)
            sort(targetList, newPivot, rightIndex)
        }

        val result = nums.toMutableList()
        sort(result, 0, result.lastIndex)
        return result
    }
}

class Solution2 {
    fun sortArray(nums: IntArray): List<Int> {
        fun swap(targetArray: MutableList<Int>, index1: Int, index2: Int) {
            val temp = targetArray[index2]
            targetArray.set(index2, targetArray[index1])
            targetArray.set(index1, temp)
        }

        fun partition(numList: MutableList<Int>, leftIndex: Int, rightIndex: Int): Int {
            val pivotIndex = leftIndex
            var l = leftIndex + 1
            var r = rightIndex
            val pivot = numList[pivotIndex]

            while(l <= r) {
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

        fun sort(targetList: MutableList<Int>, leftIndex: Int, rightIndex: Int) {
            if (leftIndex >= rightIndex) {
                return
            }

            var newPivot = partition(targetList, leftIndex, rightIndex)
            sort(targetList, leftIndex, newPivot - 1)
            sort(targetList, newPivot + 1, rightIndex)
        }

        val result = nums.toMutableList()
        sort(result, 0, result.lastIndex)
        return result
    }
}