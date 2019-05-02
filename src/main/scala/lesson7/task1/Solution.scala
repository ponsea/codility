package lesson7.task1

import scala.annotation.tailrec

// Report: https://app.codility.com/demo/results/trainingAT7EKD-DE2/

object Solution {
  val pairs = Map(
    ')' -> '(',
    '}' -> '{',
    ']' -> '['
  )

  def solution(s: String): Int = {
    @tailrec
    def f(stack: List[Char], string: List[Char]): Int = string match {
      case char :: rest => {
        pairs.get(char) match {
          case Some(opening) => {
            stack match {
              case x :: xs => if (x == opening) f(xs, rest) else 0
              case Nil => 0
            }
          }
          case None => f(char :: stack, rest)
        }
      }
      case Nil => if (stack.isEmpty) 1 else 0
    }
    f(Nil, s.toList)
  }
}
