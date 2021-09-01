package io.icednut.algorithm_exercise.leetcode.sequential_state

import cats.data.State

object StateMonadExercise {

  val nextInt: State[Int, Int] = State(s => (s + 1, s * 2))

  // 이걸 어떻게 쓰는 걸까/
  def seq: State[Int, Int] = for {
    n1 <- nextInt
    n2 <- nextInt
    n3 <- nextInt
  } yield n1 + n2 + n3
}
