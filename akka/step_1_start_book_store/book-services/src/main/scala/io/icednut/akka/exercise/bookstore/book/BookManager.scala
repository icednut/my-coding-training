package io.icednut.akka.exercise.bookstore.book

import akka.Done
import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, Behavior}

object BookManager {

  def apply(): Behavior[BookCommand] = {
    Behaviors.setup { _ =>
      Behaviors.receiveMessage {
        case FindBook(bookId, replyTo) =>
          ???
        case FindBooksByTags(tags, replyTo) =>
          ???
        case CreateBook(book, replyTo) =>
          ???
        case DeleteBook(bookId, replyTo) =>
          ???
      }
    }
  }

  sealed trait BookCommand

  case class FindBook(bookId: Int, replyTo: ActorRef[Done]) extends BookCommand

  case class DeleteBook(bookId: Int, replyTo: ActorRef[Done]) extends BookCommand

  case class FindBooksByTags(tags: Seq[String], replyTo: ActorRef[Done]) extends BookCommand

  case class FindBooksByAuthor(author: String, replyTo: ActorRef[Done]) extends BookCommand

  case class CreateBook(book: Map[String, String], replyTo: ActorRef[Done]) extends BookCommand

}
