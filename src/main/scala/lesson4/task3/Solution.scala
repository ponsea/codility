package lesson4.task3

// Report: https://app.codility.com/demo/results/trainingDSK6WN-2DH/

object Solution {
  def solution(n: Int, a: Array[Int]): Array[Int] = {
    val zeroes = IndexedSeq.fill(n)(0)
    val (result, filledMax, _) = a.foldLeft((zeroes, 0, 0)) { case ((acc, filledMax, currentMax), cur) =>
      if (cur == n + 1) {
        (acc, currentMax, currentMax)
      } else {
        val prev = acc(cur - 1)
        val next = (if (prev < filledMax) filledMax else prev) + 1
        (acc.updated(cur - 1, next), filledMax, if (next > currentMax) next else currentMax)
      }
    }
    result.map(v => if (v < filledMax) filledMax else v).toArray
  }
}
