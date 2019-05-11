package lesson6.task2

// Report: https://app.codility.com/demo/results/trainingHJJ4V5-UK8/

object Solution {
  def solution(a: Array[Int]): Int = {
    val sorted = a.sorted
    val (minuses, pluses) = sorted.partition(_ < 0)
    (minuses, pluses.reverse) match {
      case (Array(m1, m2, _*), Array(p1, p2, p3, _*)) => {
        math.max(m1 * m2 * p1, p1 * p2 * p3)
      }
      case (Array(m1, m2, _*), Array(p1, _*)) => m1 * m2 * p1
      case _ => sorted.takeRight(3).product
    }
  }
}
