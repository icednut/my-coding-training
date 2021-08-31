package io.icednut.algorithm_exercise.leetcode.pfps_exercise.step02

import io.icednut.algorithm_exercise.leetcode.pfps_exercise.step02.StronglyTypedFunctionExercise.lookup
import org.scalatest.funsuite.AnyFunSuite

class packageTest extends AnyFunSuite {

  test("강타입 함수 연습하기") {
    lookup(Username("aeinstein"), Email("aeinstein@research.com"))
    lookup(Username("aeinstein@research.com"), Email("aeinstein"))
    lookup(Username(""), Email(""))
  }
}
