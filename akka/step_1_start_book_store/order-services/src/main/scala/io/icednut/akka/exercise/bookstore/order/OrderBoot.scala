package io.icednut.akka.exercise.bookstore.order

import akka.actor.typed.scaladsl.ActorContext
import akka.actor.typed.scaladsl.AskPattern.{Askable, schedulerFromActorSystem}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import io.icednut.akka.exercise.bookstore.common.Bootstrap
import io.icednut.akka.exercise.bookstore.order.SalesHandler.FindOrderById

class OrderBoot extends Bootstrap {
  override def bootup(context: ActorContext[Nothing]): Route = {
    implicit val ec = context.system.executionContext
    val salesHandler = context.spawn(SalesHandler(), "sales-handler")

    pathPrefix("api" / "order") {
      path("orderId" ~ IntNumber) { orderId =>
        get {
          val future = salesHandler ? (FindOrderById(orderId, _))
          complete(future)
        }
      }
    }
  }
}
