package io.icednut.akka.exercise.bookstore.common

import akka.actor.typed.scaladsl.ActorContext
import akka.http.scaladsl.server.Route

trait Bootstrap {
  def bootup(context: ActorContext[Nothing]): Route
}
