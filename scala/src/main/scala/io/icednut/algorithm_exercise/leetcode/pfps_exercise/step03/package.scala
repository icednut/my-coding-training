package io.icednut.algorithm_exercise.leetcode.pfps_exercise.step03

import cats.implicits.{catsSyntaxAlternativeGuard, toFunctorOps}

case class User(email: Email, username: Username)

case class Username private(val value: String) extends AnyVal

case class Email private(val value: String) extends AnyVal

object Step03 {
  def lookup(username: Username, email: Email): User =
    User(email = email, username = username)

  def mkUsername(value: String): Option[Username] =
    (value.nonEmpty).guard[Option].as(Username(value))

  def mkEmail(value: String): Option[Email] =
    (value.contains("@")).guard[Option].as(Email(value))
}
