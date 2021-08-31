package io.icednut.algorithm_exercise.leetcode.pfps_exercise.step04

import cats.implicits.{catsSyntaxAlternativeGuard, toFunctorOps}

  sealed abstract case class Username(val value: String)

  sealed abstract case class Email(val value: String)

//  case class User(email: Email, username: Username)
//
//  object Step04 {
//    def lookup(username: Username, email: Email): User =
//      User(email = email, username = username)
//
//    def mkUsername(value: String): Option[Username] =
//      (value.nonEmpty).guard[Option].as(Username(value))
//
//    def mkEmail(value: String): Option[Email] =
//      (value.contains("@")).guard[Option].as(Email(value))
//  }
