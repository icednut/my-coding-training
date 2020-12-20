package io.icednut.algorithm_exercise.leetcode.q121

import scala.annotation.tailrec

object Solution {

  def maxProfit(prices: Array[Int]): Int = {
    @tailrec
    def run(prices: Array[Int], minIndex: Int, maxIndex: Int, maxProfit: Int): Int = {
      if (maxIndex >= prices.length) {
        maxProfit
      } else {
        prices(maxIndex) - prices(minIndex) match {
          case newMaxProfit if newMaxProfit > maxProfit =>
            if (isContinue(prices, minIndex, maxIndex)) {
              run(prices, minIndex, maxIndex + 1, newMaxProfit)
            } else {
              newMaxProfit
            }
          case newMaxProfit if newMaxProfit < 0 =>
            run(prices, maxIndex, maxIndex + 1, maxProfit)
          case _ =>
            run(prices, minIndex, maxIndex + 1, maxProfit)
        }
      }
    }

    prices match {
      case Array() => 0
      case _ => run(prices, 0, 1, 0)
    }
  }

  private def isContinue(prices: Array[Int], minIndex: Int, maxIndex: Int): Boolean = {
    val max = nextMax(prices, minIndex)
    val min = nextMin(prices, minIndex)

    (max._1 > prices(maxIndex) && max._2 > maxIndex) || // 아직 max 값이 뒤에 더 있을 경우
      (min._1 < prices(minIndex) && min._2 > minIndex) // 아직 min 값이 뒤에 더 있을 경우
  }

  private def nextMax(prices: Array[Int], startIndex: Int): (Int, Int) =
    prices.zipWithIndex
      .map(elem => if (elem._2 <= startIndex) (Int.MinValue, elem._2) else elem)
      .max

  private def nextMin(prices: Array[Int], startIndex: Int): (Int, Int) =
    prices.zipWithIndex
      .map(elem => if (elem._2 <= startIndex) (Int.MaxValue, elem._2) else elem)
      .min
}