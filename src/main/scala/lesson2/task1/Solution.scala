package lesson2.task1

object Solution {
  def solution(a: Array[Int], k: Int): Array[Int] = {
    if (a.length > 0) {
      val r = k % a.length
      a.takeRight(r) ++ a.dropRight(r)
    } else {
      a
    }
  }
}
