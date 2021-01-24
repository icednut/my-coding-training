package io.icednut.akka.exercise.bookstore.book

import akka.actor.typed.scaladsl.AskPattern.{Askable, schedulerFromActorSystem}
import akka.actor.typed.{ActorRef, ActorSystem}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.util.Timeout
import io.icednut.akka.exercise.bookstore.book.BookManager._
import io.icednut.akka.exercise.bookstore.common.Bootstrap
import spray.json.DefaultJsonProtocol.{StringJsonFormat, jsonFormat1}
import scala.concurrent.duration._

class BookBoot(bookManager: ActorRef[BookCommand]) extends Bootstrap {
  implicit val tagParamJsonFormat = jsonFormat1(TagParam)
  implicit val authorParamJsonFormat = jsonFormat1(AuthorParam)

  import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._

  override def bootup(system: ActorSystem[Nothing]): Route = pathPrefix("api" / "book") {
    implicit val timeout: Timeout = 3.seconds
    implicit val scheduler = system.scheduler

    path("bookId" ~ IntNumber) { bookId =>
      get {
        val result = bookManager ? (FindBook(bookId, _))
        complete(result)
      }
      delete {
        val result = bookManager ? (DeleteBook(bookId, _))
        complete(result)
      }
    }
    get {
      entity(as[TagParam]) { param =>
        val result = bookManager ? (FindBooksByTags(param.tags, _))
        complete(result)
      }
      entity(as[AuthorParam]) { param =>
        val result = bookManager ? (FindBooksByAuthor(param.author, _))
        complete(result)
      }
    }
    post {
      // TODO: createBook
      bookManager ? (CreateBook(???, _))
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

final case class TagParam(tags: Seq[String])

final case class AuthorParam(author: String)