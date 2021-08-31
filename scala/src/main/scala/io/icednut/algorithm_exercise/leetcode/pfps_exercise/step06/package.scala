package io.icednut.algorithm_exercise.leetcode.pfps_exercise.step06

import eu.timepit.refined.api.Refined
import eu.timepit.refined.collection.Contains

package object step06 {

  import eu.timepit.refined.types.string.NonEmptyString
  import io.estatico.newtype.macros.newtype


  @newtype case class Brand(value: NonEmptyString)

  @newtype case class Category(value: NonEmptyString)

}

object Step06 {
  type Username = String Refined Contains['g']

  //  def lookup(username: NonEmptyString): Option[User] = ???
  def lookup(username: Username): Option[User] = ???
}

case class User()
