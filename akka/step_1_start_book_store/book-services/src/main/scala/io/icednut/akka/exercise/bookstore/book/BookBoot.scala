package io.icednut.akka.exercise.bookstore.book

import akka.actor.typed.ActorSystem
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import io.icednut.akka.exercise.bookstore.common.Bootstrap
import spray.json.DefaultJsonProtocol.{StringJsonFormat, jsonFormat1}

class BookBoot extends Bootstrap {
  implicit val tagParamJsonFormat = jsonFormat1(TagParam)
  implicit val authorParamJsonFormat = jsonFormat1(AuthorParam)

  import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._

  override def bootup(system: ActorSystem[Nothing]): Route = pathPrefix("api" / "book") {
    path("bookId" ~ IntNumber) { bookId =>
      get {
        // TODO: findBook
        ???
      }
      delete {
        // TODO: DeleteBook
        ???
      }
    }
    get {
      entity(as[TagParam]) { tag =>
        // TODO: FindBooksByTags
        ???
      }
      entity(as[AuthorParam]) { author =>
        // TODO: FindBooksByAuthor
        ???
      }
    }
    post {
      // TODO: createBook
      ???
    }
    path("bookId" ~ IntNumber / "tag" / Segment) { (bookId, tag) =>
      put {
        // TODO: addTagToBook
        ???
      }
      delete {
        // TODO: RemoveTagFromBook
        ???
      }
    }
    path("bookId" ~ IntNumber / "inventory" ~ IntNumber) { (bookId, amount) =>
      // TODO: AddInventoryBook
      ???
    }
  }
}

final case class TagParam(tag: String)

final case class AuthorParam(author: String)