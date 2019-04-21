package lesson2.task2

object Solution {
  def solution(a: Array[Int]): Int = {
    a.foldLeft(Map.empty[Int, Int]) { (acc, cur) =>
      acc + (cur -> acc.get(cur).fold(1)(_ + 1))
    }.collectFirst{
      case (key, count) if count % 2 == 1 => key
    }.get
  }
}
