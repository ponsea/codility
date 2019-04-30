package lesson2.task1

// Report: https://app.codility.com/demo/results/trainingPG3ZV2-MHW/

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
