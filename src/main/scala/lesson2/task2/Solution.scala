package lesson2.task2

// Report: https://app.codility.com/demo/results/training5U6XVD-T44/

object Solution {
  def solution(a: Array[Int]): Int = {
    a.foldLeft(Set.empty[Int]) { (acc, cur) =>
      if (acc.contains(cur)) acc - cur else acc + cur
    }.head
  }
}
