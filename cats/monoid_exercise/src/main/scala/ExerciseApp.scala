package io.icednut.cats.exercise

import cats._
import cats.implicits._

object ExerciseApp extends App{

  val result1 = Monoid[Map[String, Int]].combineAll(List(Map("a" -> 1, "b" -> 2), Map("a" -> 3)))
  val result2 = Monoid[Map[String, Int]].combineAll(List())

  println(result1)
  println(result2)

  val l = List(1, 2, 3, 4, 5)
  val result3 = l.foldMap(identity)
  val result4 = l.foldMap(i => i.toString)

  println(result3)
  println(result4)

}
