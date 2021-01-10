package io.icednut.akka.exercise.bookstore.order

import akka.actor.typed.ActorSystem
import akka.http.scaladsl.server.Route
import io.icednut.akka.exercise.bookstore.common.Bootstrap

class OrderBoot extends Bootstrap {
  override def bootup(system: ActorSystem[Nothing]): List[Route] = ???
}
