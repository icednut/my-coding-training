package io.icednut.akka.exercise.bookstore.server

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.{ActorContext, Behaviors}
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.{Directives, Route}
import com.typesafe.config.ConfigFactory
import io.icednut.akka.exercise.bookstore.common.{Bootstrap, PostgresDb, UserRegistry, UserRoutes}

import scala.jdk.CollectionConverters._
import scala.util.{Failure, Success}

object Server extends App {
  val conf = ConfigFactory.load.getConfig("bookstore")
  PostgresDb.init(conf)

  val rootBehavior = Behaviors.setup[Nothing] { context =>
    val userRegistryActor = context.spawn(UserRegistry(), "UserRegistryActor")
    context.watch(userRegistryActor)

    implicit val c = context

    val routes = new UserRoutes(userRegistryActor)(context.system)
    val endpoints: Route = conf.getStringList("serviceBoots")
      .asScala
      .map(toBootClass)
      .map(_.bootup())
      .foldRight(routes.userRoutes) {
        case (endpoint, route) =>
          context.log.info("Adding endpoint: {}", endpoint)
          Directives.concat(route, endpoint)
      }

    startHttpServer(endpoints)(context.system)
    Behaviors.empty
  }

  ActorSystem[Nothing](guardianBehavior = rootBehavior, name = "HelloAkkaHttpServer", config = conf)

  private def toBootClass(bootPrefix: String)(implicit context: ActorContext[Nothing]) = {
    val clazz = s"io.icednut.akka.exercise.bookstore.${bootPrefix.toLowerCase()}.${bootPrefix}Boot"
    Class.forName(clazz).newInstance().asInstanceOf[Bootstrap]
  }

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
