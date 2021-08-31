package io.icednut.algorithm_exercise.leetcode.pfps_exercise.step06

import eu.timepit.refined.auto._
import io.icednut.algorithm_exercise.leetcode.pfps_exercise.step06.step06.Brand
import org.scalatest.funsuite.AnyFunSuite

class packageTest extends AnyFunSuite {

  test("강타입 함수 연습") {
    //    lookup("") // error
    //    lookup("aeinstein") // error
    //    lookup("csagan") // compiles
  }

  test("강타입 함수 연습 2") {

    val brand: Brand = Brand("foo")
  }
}
