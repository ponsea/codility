package lesson10.task1

// Report: https://app.codility.com/demo/results/training2N35BJ-ZFY/

object Solution {
  def solution(n: Int): Int = {
    (1 to math.sqrt(n).toInt).foldLeft(Set.empty[Int]) { (acc, cur) =>
      val quotient = n / cur
      val remainder = n % cur
      if (remainder == 0) acc + cur + quotient
      else acc
    }.size
  }
}
