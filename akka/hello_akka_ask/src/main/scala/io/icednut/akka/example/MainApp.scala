package io.icednut.akka.example

import akka.actor.typed.scaladsl.AskPattern.Askable
import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, ActorSystem, Behavior, Scheduler}
import akka.util.Timeout
import io.icednut.akka.example.HelloActor.{Greeting, Message}

import scala.concurrent.duration.DurationInt
import scala.concurrent.{ExecutionContextExecutor, Future}

object MainApp {

  def main(args: Array[String]): Unit = {
    val helloActorBehavior: Behavior[Message] = HelloActor()
    val helloActor: ActorSystem[HelloActor.Message] =
      ActorSystem(guardianBehavior = helloActorBehavior, name = "helloActorSystem")

    implicit val timeout: Timeout = 10.millis
    implicit val scheduler: Scheduler = helloActor.scheduler
    implicit val ec: ExecutionContextExecutor = helloActor.executionContext

    val helloWorldFuture: Future[HelloActor.Response] = helloActor.ask(replyRef => Greeting("World!", replyRef))
    val helloAkkaFuture: Future[HelloActor.Response] = helloActor ? (replyRef => Greeting("Akka!", replyRef))

    val combinedFuture: Future[Seq[HelloActor.Response]] = Future.sequence(Seq(helloWorldFuture, helloAkkaFuture))

    combinedFuture.onComplete(results => results.toEither match {
      case Right(responses) =>
        helloActor.log.info(s"responses == $responses")
      case Left(exception) =>
        helloActor.log.error(exception.getMessage, exception)
    })
  }
}

object HelloActor {

  def apply(): Behavior[Message] = {
    Behaviors.receive { (ctx, message) =>
      (ctx, message) match {
        case (context, Greeting(body, replyRef)) =>
          val greetingMessage = s"Hello, $body"
          replyRef ! Greeted(greetingMessage)
          Behaviors.same
      }
    }
  }

  sealed trait Message
  case class Greeting(body: String, replyRef: ActorRef[Response]) extends Message

  sealed trait Response
  case class Greeted(result: String) extends Response
}