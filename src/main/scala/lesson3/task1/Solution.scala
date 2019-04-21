package lesson3.task1

object Solution {
  def solution(x: Int, y: Int, d: Int): Int = {
    math.ceil((y - x) / d.toDouble).toInt
  }
}
