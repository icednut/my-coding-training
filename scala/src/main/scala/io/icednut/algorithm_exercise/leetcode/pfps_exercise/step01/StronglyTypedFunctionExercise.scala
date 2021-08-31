package io.icednut.algorithm_exercise.leetcode.pfps_exercise.step01

object StronglyTypedFunctionExercise {
  def lookup(username: String, email: String): Option[User] = {
    Some(User(email = email, username = username))
  }
}

case class User(email: String, username: String)
