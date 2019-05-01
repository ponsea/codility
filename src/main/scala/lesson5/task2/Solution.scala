package lesson5.task2

import scala.collection.immutable.{TreeMap, TreeSet}

// Report: https://app.codility.com/demo/results/training7C4QFS-PVW/

object Solution {
  val impactOf = Map(
    'A' -> 1,
    'C' -> 2,
    'G' -> 3,
    'T' -> 4
  )

  def solution(s: String, p: Array[Int], q: Array[Int]): Array[Int] = {
    val zero = TreeMap[Int, TreeSet[Int]](
      1 -> TreeSet.empty,
      2 -> TreeSet.empty,
      3 -> TreeSet.empty,
      4 -> TreeSet.empty
    )
    val appearanceMap = s.zipWithIndex.foldLeft(zero) { case (acc, (nucleotide, position)) =>
      val impact = impactOf(nucleotide)
      acc.updated(impact, acc(impact) + position)
    }
    (p zip q).map { case (left, right) =>
      appearanceMap.collectFirst {
        case (impact, positions) if positions.range(left, right + 1).nonEmpty => impact
      }.get
    }
  }

  // def simpleSolution(s: String, p: Array[Int], q: Array[Int]): Array[Int] = {
  //   val impacts = s.map(impactOf(_))
  //   (p zip q).map{ case (left, right) => impacts.slice(left, right + 1).min }
  // }
}
