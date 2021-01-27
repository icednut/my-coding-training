package io.icednut.akka.exercise.bookstore.order

import akka.Done
import akka.actor.typed.{ActorRef, Behavior}
import akka.actor.typed.scaladsl.Behaviors

object SalesHandler {

  def apply(): Behavior[SalesCommand] = {
    Behaviors.setup[SalesCommand] { context =>
      ???
    }
  }

  trait SalesCommand

  case class FindOrderById(orderId: Int, replyTo: ActorRef[Done]) extends SalesCommand

}
