package io.icednut.akka.exercise.bookstore.book

import akka.Done
import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, Behavior}
import io.icednut.akka.exercise.bookstore.common.BookstoreDao

object BookManager {

  type BookId = Int

  def apply(): Behavior[BookCommand] = {
    Behaviors.setup { _ =>

      val dao = new BookManagerDao

      Behaviors.receiveMessage {
        case FindBook(bookId, replyTo) =>
          ???
        case FindBooksByTags(tags, replyTo) =>
          ???
        case CreateBook(book, replyTo) =>
          ???
        case DeleteBook(bookId, replyTo) =>
          ???
        case AddTagToBook(bookId, tag, replyTo) =>
          ???
        case RemoveTagFromBook(bookId, tag, replyTo) =>
          ???
        case AddInventoryBook(bookId, amount, replyTo) =>
          ???
      }
    }
  }

  sealed trait BookCommand

  case class FindBook(bookId: BookId, replyTo: ActorRef[Done]) extends BookCommand

  case class DeleteBook(bookId: BookId, replyTo: ActorRef[Done]) extends BookCommand

  case class FindBooksByTags(tags: Seq[String], replyTo: ActorRef[Done]) extends BookCommand

  case class FindBooksByAuthor(author: String, replyTo: ActorRef[Done]) extends BookCommand

  case class CreateBook(book: BookParam, replyTo: ActorRef[Done]) extends BookCommand

  case class AddTagToBook(bookId: BookId, tag: String, replyTo: ActorRef[Done]) extends BookCommand

  case class RemoveTagFromBook(bookId: BookId, tag: String, replyTo: ActorRef[Done]) extends BookCommand

  case class AddInventoryBook(bookId: BookId, amount: Int, replyTo: ActorRef[Done]) extends BookCommand

}

class BookManagerDao() extends BookstoreDao {
}