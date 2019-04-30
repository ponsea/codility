package lesson3.task3

// Report: https://app.codility.com/demo/results/trainingYWHRFX-QY4/

object Solution {
  def solution(a: Array[Int]): Int = {
    val sumsFromLeft = a.tail.foldLeft(IndexedSeq(a.head)) { (acc, cur) =>
      acc :+ (acc.last + cur)
    }
    val sumsFromRight = a.init.foldRight(IndexedSeq(a.last)) { (cur, acc) =>
      (cur + acc.head) +: acc
    }
    (sumsFromLeft.init zip sumsFromRight.tail)
      .map{ case (leftSum, rightSum) => math.abs(leftSum - rightSum) }
      .min
  }
}
