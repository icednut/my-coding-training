package io.icednut.leetcode.exercise.day00.quickselection

/**
 * @author will.109
 * @date 2020/03/24
 **/
class QuickSelectionWithMedian {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val numList = nums.toMutableList()
        return quickSelection(numList, 0, numList.lastIndex, numList.lastIndex - (k - 1))
    }

    private fun swap(numList: MutableList<Int>, first: Int, next: Int) {
        val temp = numList[first]
        numList[first] = numList[next]
        numList[next] = temp
    }

    private fun partition(numList: MutableList<Int>, leftIndex: Int, rightIndex: Int, pivotIndex: Int): Int {
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

    private fun sortAndGetMedian(numList: MutableList<Int>, leftIndex: Int, rightIndex: Int): Int {
        var i = leftIndex + 1
        var j = i
        while (i <= rightIndex) {
            j = i
            while (j > leftIndex && numList[j - 1] > numList[j]) {
                swap(numList, j - 1, j)
                j--
            }
            i++
        }
        return (leftIndex + rightIndex) / 2
    }

    private fun quickselectPos(numList: MutableList<Int>, leftIndex: Int, rightIndex: Int, k: Int): Int {
        if (leftIndex == rightIndex) {
            return leftIndex
        }

        var pivotPos = choosePivot(numList, leftIndex, rightIndex)
        pivotPos = partition(numList, leftIndex, rightIndex, pivotPos)

        if (pivotPos == k) {
            return pivotPos
        } else if (pivotPos > k) {
            return quickselectPos(numList, leftIndex, pivotPos - 1, k)
        } else {
            return quickselectPos(numList, pivotPos + 1, rightIndex, k)
        }
    }

    private fun choosePivot(numList: MutableList<Int>, leftIndex: Int, rightIndex: Int): Int {
        if (rightIndex - leftIndex < 5) {
            return sortAndGetMedian(numList, leftIndex, rightIndex)
        }

        var current = leftIndex
        for (i in leftIndex..(rightIndex + 1) step 5) {
            val medianPos = sortAndGetMedian(numList, i, Integer.min(i + 4, rightIndex))
            swap(numList, current, medianPos)
            current++
        }
        return quickselectPos(numList, leftIndex, current - 1, (current + leftIndex - 1) / 2)
    }

    private fun quickSelection(
        numList: MutableList<Int>,
        leftIndex: Int,
        rightIndex: Int,
        k: Int
    ): Int {
        var newPivot = choosePivot(numList, leftIndex, rightIndex)
        newPivot = partition(numList, leftIndex, rightIndex, newPivot)

        if (newPivot == k) {
            return numList[k]
        } else if (newPivot > k) {
            return quickSelection(numList, leftIndex, newPivot - 1, k)
        } else {
            return quickSelection(numList, newPivot + 1, rightIndex, k)
        }
    }
}