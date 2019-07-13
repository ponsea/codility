package lesson9.task2

// Report: https://app.codility.com/demo/results/training6WMV2N-UMU/

object Solution {
  def solution(a: Array[Int]): Int = {
    val head :: tail = a.toList
    val (_, result) = tail.foldLeft(head, head) {
      case ((maxEnding, maxSlice), cur) =>
        val m = math.max(maxEnding + cur, cur)
        (m, math.max(maxSlice, m))
    }
    result
  }
}
