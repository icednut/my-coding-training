package io.icednut.akka.exercise.bookstore.credit

import akka.actor.typed.scaladsl.ActorContext
import akka.http.scaladsl.server.Route
import io.icednut.akka.exercise.bookstore.common.Bootstrap

class CreditBoot extends Bootstrap {
  override def bootup(context: ActorContext[Nothing]): Route = null
}
