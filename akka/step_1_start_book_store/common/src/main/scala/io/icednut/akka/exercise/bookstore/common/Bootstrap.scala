package io.icednut.akka.exercise.bookstore.common

import akka.actor.typed.ActorSystem
import akka.http.scaladsl.server.Route

trait Bootstrap {
  def bootup(system: ActorSystem[Nothing]): Route
}
