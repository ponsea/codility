package lesson7.task4

// Report: https://app.codility.com/demo/results/trainingEK6GAJ-6ZZ/

object Solution {
  def solution(h: Array[Int]): Int = {
    val (result, _) = h.foldLeft(0, Nil: List[Int]) { (acc, cur) =>
      val (count, stack) = acc
      val lower = stack.dropWhile(_ > cur)
      if (lower.headOption.exists(_ == cur)) {
        (count, lower)
      } else {
        (count + 1, cur :: lower)
      }
    }
    result
  }
}
