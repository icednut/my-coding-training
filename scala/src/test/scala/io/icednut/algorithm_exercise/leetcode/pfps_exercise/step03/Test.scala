package io.icednut.algorithm_exercise.leetcode.pfps_exercise.step03

import cats.implicits.catsSyntaxTuple2Semigroupal
import io.icednut.algorithm_exercise.leetcode.pfps_exercise.step03.Step03._
import org.scalatest.funsuite.AnyFunSuite

class Test extends AnyFunSuite {

  test("강타입 함수 연습하기") {
    (
      mkUsername("aeistein"),
      mkEmail("aeinstein@research.com")
    ).mapN {
      case (username, email) => lookup(username, email)
    }
  }

  test("강타입 함수 연습하기 2") {
    (
      mkUsername("aeistein"),
      mkEmail("aeinstein@research.com")
    ).mapN {
      case (username, email) =>
        lookup(username.copy(value = ""), email) // case class의 copy 메소드로 인해 데이터가 훼손될 여지가 남아있음
    }
  }
}
