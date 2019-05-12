package lesson7.task2

// Report: https://app.codility.com/demo/results/trainingC2AM2Q-VRW/

object Solution {
  def solution(a: Array[Int], b: Array[Int]): Int = {
    val (numOfPassed, sizesOfDownFish) = (a zip b).foldLeft((0, Seq.empty[Int])) { (acc, cur) =>
      val (numOfPassed, sizesOfDownFish) = acc
      val (size, direction) = cur

      if (direction == 1) {
        (numOfPassed, size +: sizesOfDownFish)
      } else {
        val notEaten = sizesOfDownFish.dropWhile(_ < size)
        (if (notEaten.isEmpty) numOfPassed + 1 else numOfPassed, notEaten)
      }
    }
    numOfPassed + sizesOfDownFish.length
  }
}

