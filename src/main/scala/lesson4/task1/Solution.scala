package lesson4.task1

import scala.util.Try

object Solution {
  def solution(a: Array[Int]): Int = {
    val table = IndexedSeq.fill(a.length)(false)
    Try(
      a.foldLeft(table) { (acc, cur) =>
        if (acc(cur - 1)) throw new Exception("duplicated!")
        else acc.updated(cur - 1, true)
      }
    ).fold(_ => 0, _ => 1)
  }
}
