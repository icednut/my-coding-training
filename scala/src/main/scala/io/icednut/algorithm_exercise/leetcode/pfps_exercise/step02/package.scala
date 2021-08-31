package io.icednut.algorithm_exercise.leetcode.pfps_exercise.step02

case class User(email: Email, username: Username)

case class Username(val value: String) extends AnyVal

case class Email(val value: String) extends AnyVal

object StronglyTypedFunctionExercise {
  def lookup(username: Username, email: Email): Option[User] = {
    Some(User(email = email, username = username))
  }
}
