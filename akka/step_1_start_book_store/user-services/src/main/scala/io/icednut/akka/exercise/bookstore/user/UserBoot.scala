package io.icednut.akka.exercise.bookstore.user

import akka.actor.typed.ActorSystem
import akka.http.scaladsl.server.Route
import io.icednut.akka.exercise.bookstore.common.Bootstrap

class UserBoot extends Bootstrap {
  override def bootup(system: ActorSystem[Nothing]): Route = ???
}
