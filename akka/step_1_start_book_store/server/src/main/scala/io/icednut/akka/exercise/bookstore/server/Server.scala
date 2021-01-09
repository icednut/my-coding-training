package io.icednut.akka.exercise.bookstore.server

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import com.typesafe.config.ConfigFactory
import io.icednut.akka.exercise.bookstore.common.PostgresDb

import scala.util.{Failure, Success}

object Server extends App {
  val conf = ConfigFactory.load.getConfig("bookstore")
  PostgresDb.init(conf)

  val rootBehavior = Behaviors.setup[Nothing] { context =>
    //    val userRegistryActor = context.spawn(UserRegistry(), "UserRegistryActor")
    //    context.watch(userRegistryActor)

    //    val routes = new UserRoutes(userRegistryActor)(context.system)
    //    startHttpServer(routes.userRoutes)(context.system)

    Behaviors.empty
  }

  ActorSystem[Nothing](rootBehavior, "HelloAkkaHttpServer")

  private def startHttpServer(routes: Route)(implicit system: ActorSystem[_]): Unit = {
    // Akka HTTP still needs a classic ActorSystem to start
    import system.executionContext

    val futureBinding = Http().newServerAt("localhost", 8080).bind(routes)
    futureBinding.onComplete {
      case Success(binding) =>
        val address = binding.localAddress
        system.log.info("Server online at http://{}:{}/", address.getHostString, address.getPort)
      case Failure(ex) =>
        system.log.error("Failed to bind HTTP endpoint, terminating system", ex)
        system.terminate()
    }
  }
}
