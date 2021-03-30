package io.icednut.algorithm_exercise.leetcode.q39

object Solution {
  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
    def run(resultElements: Array[Int]): Set[List[Int]] = {
      var result: Set[List[Int]] = Set(resultElements.toList)

      for (i <- 0 until candidates.length) {
        val nextResults = resultElements :+ candidates(i)
        if (nextResults.sum <= target && !isContains(result, nextResults)) {
          val newResults = run(nextResults.sorted)

          for {
            newResult <- newResults
          } {
            if (newResult.sum == target) {
              result = result + newResult
            }
          }
        }
      }
      result
    }

    run(Array()).toList.filter(_.nonEmpty)
  }

  private def isContains(results: Set[List[Int]], element: Array[Int]): Boolean = {
    val sortedElement = element.toList.sorted
    results.exists(result => result == sortedElement)
  }
}
