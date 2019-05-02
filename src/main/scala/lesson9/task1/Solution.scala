package lesson9.task1

// Report: https://app.codility.com/demo/results/training6FAJWD-RMH/

object Solution {
  def solution(a: Array[Int]): Int = {
    if (a.isEmpty) return 0

    val prices = a.toIndexedSeq
    val transitionOfMax = prices.init.foldRight(IndexedSeq(a.last)) { (cur, acc) =>
      if (cur > acc.head) cur +: acc else acc.head +: acc
    }
    (prices.init zip transitionOfMax.tail).foldLeft(0) { case (maxProfit, (price, futureMax)) =>
      val profit = futureMax - price
      if (profit > maxProfit) profit else maxProfit
    }
  }
}
