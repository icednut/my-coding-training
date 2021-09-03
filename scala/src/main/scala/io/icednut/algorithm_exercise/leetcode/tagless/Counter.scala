package io.icednut.algorithm_exercise.leetcode.tagless

import cats.effect.{IO, Ref, Resource, Sync}
import dev.profunktor.redis4cats.RedisCommands
import dev.profunktor.redis4cats.effect.MkRedis
import io.estatico.newtype.macros.newtype

trait Counter[F[_]] {
  def incr: F[Unit]

  def get: F[Int]
}


object Counter {

  //  def make[F[_] : Functor](key: RedisKey, cmd: RedisCommands[F, String, Int]): Counter[F] =
  //    new Counter[F] {
  //      override def incr: F[Unit] = cmd.incr(key.value).void
  //
  //      override def get: F[Int] = cmd.get(key.value).map(_.getOrElse(0))
  //    }

  def make[F[_] : Sync](key: RedisKey): Resource[F, Counter[F]] =
    makeRedis[F].map { redis =>
      new Counter[F] {
        override def incr: F[Unit] = redis.incr(key.value)

        override def get: F[Int] = redis.get(key.value).map(_.getOrElse(0))
      }
    }

  private def makeRedis[F[_] : MkRedis]: Resource[IO, RedisCommands[IO, String, Int]] = ???

  def testCounter[F[_]](ref: Ref[F, Int]): Counter[F] = new Counter[F] {
    override def incr: F[Unit] = ref.update(_ + 1)

    override def get: F[Int] = ref.get
  }

  @newtype case class RedisKey(value: String)
}
