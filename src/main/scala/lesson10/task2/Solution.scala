package lesson10.task2

// Report: https://app.codility.com/demo/results/trainingJYFTF2-9ET/

object Solution {
  def solution(n: Int): Int = {
    (1 to math.sqrt(n).toInt)
      .reverse
      .collectFirst { case i if n % i == 0 => 2 * (i + n / i) }
      .get
  }
}
