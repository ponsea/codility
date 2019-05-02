package lesson8.task1

import scala.annotation.tailrec

// Report: https://app.codility.com/demo/results/trainingDXFER2-26N/

object Solution {
  def solution(a: Array[Int]): Int = {
    val boundary = a.length / 2 + 1
    @tailrec
    def f(counts: Map[Int, Int], i: Int): Int = {
      if (a.isDefinedAt(i)) {
        val number = a(i)
        val count = counts.getOrElse(number, 0) + 1
        if (count >= boundary) i
        else f(counts.updated(number, count), i + 1)
      } else {
        -1
      }
    }
    f(Map.empty, 0)
  }
}
