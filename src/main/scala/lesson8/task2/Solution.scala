package lesson8.task2

// Report: https://app.codility.com/demo/results/training2JEGEV-S4V/

object Solution {
  def solution(a: Array[Int]): Int = {
    val leadersFromLeft = transitionOfLeader(a)
    val leadersFromRight = transitionOfLeader(a.reverse).reverse
    (leadersFromLeft.init zip leadersFromRight.tail).foldLeft(0) { case (count, (left, right)) =>
      val areSame = (for {
        l <- left
        r <- right
      } yield l == r).getOrElse(false)
      if (areSame) count + 1 else count
    }
  }

  def transitionOfLeader(a: Array[Int]) = {
    val zero: (List[Option[Int]], Map[Int, Int]) = (Nil, Map.empty)
    val (transition, _) = a.zipWithIndex.foldLeft(zero) { (acc, cur) =>
      val (leaders, counts) = acc
      val (number, i) = cur
      val boundaryOfLeadar = (i + 1) / 2
      val count = counts.getOrElse(number, 0) + 1
      val currentLeader =
        if (count > boundaryOfLeadar) {
          Some(number)
        } else {
          leaders match {
            case Some(l) :: _ if counts(l) > boundaryOfLeadar => Some(l)
            case _ => None
          }
        }
      (currentLeader :: leaders, counts.updated(number, count))
    }
    transition.reverse
  }
}
