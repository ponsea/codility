package lesson3.task2

object Solution {
  def solution(a: Array[Int]): Int = {
    val table = IndexedSeq.fill(a.length + 1)(false)
    a.foldLeft(table) { (acc, cur) =>
      acc.updated(cur - 1, true)
    }.indexOf(false) + 1
  }
}
