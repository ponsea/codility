package lesson5.task1

// Report: https://app.codility.com/demo/results/trainingFY2EDB-YKZ/

object Solution {
  def solution(a: Array[Int]): Int = {
    val (count, _) = a.foldLeft((0, 0)) { case ((count, numOfeast), car) =>
        if (count > 1000000000) return -1
        if (car == 0) (count, numOfeast + 1)
        else (count + numOfeast, numOfeast)
    }
    count
  }
}
