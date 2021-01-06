package io.icednut.akka.example

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorSystem, Behavior}
import io.icednut.akka.example.HelloActor.{Greeting, Message}

object MainApp {

  def main(args: Array[String]): Unit = {
    val helloActorBehavior: Behavior[Message] = HelloActor()
    val helloActor: ActorSystem[HelloActor.Message] =
      ActorSystem(guardianBehavior = helloActorBehavior, name = "helloActorSystem")

    helloActor ! Greeting("World!")
    helloActor ! Greeting("Akka!")
  }
}

object HelloActor {

  def apply(): Behavior[Message] = {
    Behaviors.receive { (ctx, message) =>
      (ctx, message) match {
        case (context, Greeting(body)) =>
          context.log.info(s"Hello, $body")
          Behaviors.same
      }
    }
  }

  sealed trait Message

  case class Greeting(body: String) extends Message

}