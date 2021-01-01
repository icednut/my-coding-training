package io.icednut.akka.example

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorSystem, Behavior}
import io.icednut.akka.example.HelloActor.Greeting

object MainApp {

  def main(args: Array[String]): Unit = {
    val helloActor: ActorSystem[HelloActor.Message] = ActorSystem(guardianBehavior = HelloActor(), "helloActorSystem")

    helloActor ! Greeting("Hello, world!")
    helloActor ! Greeting("Hello, Akka!")
  }
}

object HelloActor {

  def apply(): Behavior[Message] = {
    Behaviors.receiveMessage {
      case Greeting(body) =>
        println(body)
        Behaviors.same
    }
  }

  sealed trait Message

  case class Greeting(body: String) extends Message

}
