package lesson11.task1

import scala.collection.immutable.TreeSet

// Report: https://app.codility.com/demo/results/training6XT6MH-7JP/

object Solution {
  val primes: Stream[Int] = 2 #:: Stream.from(3).filter { n => !primes.takeWhile(_ <= math.sqrt(n)).exists(n % _ == 0) }

  def solution(n: Int, p: Array[Int], q: Array[Int]): Array[Int] = {
    val semiprimes = (for {
      p1 <- primes.takeWhile(_ * 2 <= n)
      p2 <- primes.takeWhile(_ * p1 <= n)
    } yield p1 * p2).to[TreeSet]

    (p zip q).foldLeft(Seq.empty[Int]) { case (acc, (left, right)) =>
      semiprimes.range(left, right + 1).size +: acc
    }.reverse.toArray
  }
}
