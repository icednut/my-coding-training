package io.icednut.akka.exercise.bookstore.common

import io.icednut.akka.exercise.bookstore.common.UserRegistry.ActionPerformed
import spray.json.DefaultJsonProtocol.{IntJsonFormat, StringJsonFormat, immSeqFormat, jsonFormat1, jsonFormat3}

object JsonFormats {
  // import the default encoders for primitive types (Int, String, Lists etc)

  implicit val userJsonFormat = jsonFormat3(User)
  implicit val usersJsonFormat = jsonFormat1(Users)

  implicit val actionPerformedJsonFormat = jsonFormat1(ActionPerformed)
}
