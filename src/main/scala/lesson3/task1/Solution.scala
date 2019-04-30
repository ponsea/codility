package lesson3.task1

// Report: https://app.codility.com/demo/results/training2Q9KN2-UJ6/

object Solution {
  def solution(x: Int, y: Int, d: Int): Int = {
    math.ceil((y - x) / d.toDouble).toInt
  }
}
