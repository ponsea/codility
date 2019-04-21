package lesson1.task1

object Solution {
  def solution(n: Int): Int = {
    val (max, _, _) = n.toBinaryString.foldLeft((0, 0, false)) { case ((max, count, isCounting), current) =>
      if (isCounting) {
        if (current == '0') {
          (max, count + 1, true)
        } else {
          if (count > max) (count, 0, true)
          else (max, 0, true)
        }
      } else {
        if (current == '1') (0, 0, true)
        else (0, 0, false)
      }
    }
    max
  }
}
