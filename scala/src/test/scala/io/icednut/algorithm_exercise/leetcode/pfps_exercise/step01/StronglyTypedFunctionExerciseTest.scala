package io.icednut.algorithm_exercise.leetcode.pfps_exercise.step01

import io.icednut.algorithm_exercise.leetcode.pfps_exercise.step01.StronglyTypedFunctionExercise._
import org.scalatest.funsuite.AnyFunSuite

class StronglyTypedFunctionExerciseTest extends AnyFunSuite {

  test("강타입 함수 연습하기") {
    lookup("aeinstein@research.com", "aeinstein")
    lookup("aeinstein", "123")
    lookup("", "")
  }
}
