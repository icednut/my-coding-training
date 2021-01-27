package io.icednut.akka.exercise.bookstore.book

import akka.actor.typed.scaladsl.ActorContext
import akka.actor.typed.scaladsl.AskPattern.Askable
import akka.actor.typed.{ActorRef, ActorSystem}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.util.Timeout
import io.icednut.akka.exercise.bookstore.book.BookManager._
import io.icednut.akka.exercise.bookstore.common.Bootstrap
import spray.json.DefaultJsonProtocol._

import scala.concurrent.duration._

class BookBoot extends Bootstrap {
  implicit val tagParamJsonFormat = jsonFormat1(TagParam)
  implicit val authorParamJsonFormat = jsonFormat1(AuthorParam)
  implicit val bookParamJsonFormat = jsonFormat4(BookParam)

  import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._

  override def bootup(context: ActorContext[Nothing]): Route = {
    val bookManager: ActorRef[BookCommand] = context.spawn(BookManager(), "book-manager")

    pathPrefix("api" / "book") {
      implicit val timeout: Timeout = 3.seconds
      implicit val scheduler = context.system.scheduler

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
        entity(as[BookParam]) { param =>
          val future = bookManager ? (CreateBook(param, _))
          complete(future)
        }
      }
      path("bookId" ~ IntNumber / "tag" / Segment) { (bookId, tag) =>
        put {
          val future = bookManager ? (AddTagToBook(bookId, tag, _))
          complete(future)
        }
        delete {
          val future = bookManager ? (RemoveTagFromBook(bookId, tag, _))
          complete(future)
        }
      }
      path("bookId" ~ IntNumber / "inventory" ~ IntNumber) { (bookId, amount) =>
        val future = bookManager ? (AddInventoryBook(bookId, amount, _))
        complete(future)
      }
    }
  }

}

final case class TagParam(tags: Seq[String])

final case class AuthorParam(author: String)

final case class BookParam(title: String, author: String, tags: List[String], cost: Double)