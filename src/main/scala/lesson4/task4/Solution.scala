package lesson4.task4

// Repost: https://app.codility.com/demo/results/training4234BD-D8M/

object Solution {
  def solution(a: Array[Int]): Int = {
    val nums = a.toSet
    Stream.from(1).find(!nums.contains(_)).get
  }
}
