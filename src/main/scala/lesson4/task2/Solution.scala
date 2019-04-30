package lesson4.task2

import scala.annotation.tailrec

// Report: https://app.codility.com/demo/results/trainingU79D62-9KE/

object Solution {
  def solution(x: Int, a: Array[Int]): Int = {
    @tailrec
    def f(time: Int, notCovered: Set[Int]): Int = {
      if (a.isDefinedAt(time)) {
        val rest = notCovered - a(time)
        if (rest.isEmpty) time else f(time + 1, rest)
      } else {
        -1
      }
    }
    f(0, (1 to x).toSet)
  }
}
