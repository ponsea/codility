package lesson12.task1

import scala.annotation.tailrec

object Solution {
  def solution(n: Int, m: Int): Int = {
    @tailrec
    def f(acc: Seq[Boolean], count: Int, i: Int): Int = {
      if (acc(i)) {
        count
      } else {
        val next = if (i + m < n) i + m else i + m - n
        f(acc.updated(i, true), count + 1, next)
      }
    }
    f(IndexedSeq.fill(n)(false), 0, 0)
  }
  // def solution(n: Int, m: Int): Int = {
  //   def gaps(prev: Int): Stream[Int] = prev #:: gaps(m - ((n - prev) % m))
  //   // -0,~1,$2,=3,!4,-5,~6,$7,=8,!9,-10,~11
  //   gaps(0).takeWhile(_ != m).map(gap => (n - (gap % m + 1)) / m + 1).sum
  // }
}
