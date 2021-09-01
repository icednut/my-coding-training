package io.icednut.algorithm_exercise.leetcode.pfps_exercise

import cats.data.EitherNel
import cats.implicits._
import eu.timepit.refined.api.RefType.refinedRefType
import eu.timepit.refined.api.{Refined, RefinedTypeOps, Validate}
import eu.timepit.refined.collection.Contains
import eu.timepit.refined.refineV
import eu.timepit.refined.types.string.NonEmptyString
import io.estatico.newtype.macros.newtype
import io.icednut.algorithm_exercise.leetcode.pfps_exercise.step07.NewtypeRefinedOps.validate

package object step07 {

  type UserNameR = NonEmptyString
  type NameR = NonEmptyString
  type EmailR = String Refined Contains['@']

  object UserNameR extends RefinedTypeOps[UserNameR, String]

  object NameR extends RefinedTypeOps[NameR, String]

  object EmailR extends RefinedTypeOps[EmailR, String]

  @newtype case class UserName(value: UserNameR)
  @newtype case class Name(value: NameR)
  @newtype case class Email(value: EmailR)

  def mkPerson(u: String, n: String, e: String): EitherNel[String, Person] =
    (
      UserNameR.from(u).toEitherNel.map(UserName.apply),
      NameR.from(n).toEitherNel.map(Name.apply),
      EmailR.from(e).toEitherNel.map(Email.apply),
    ).parMapN(Person.apply)


  def mkPerson2(u: String, n: String, e: String): EitherNel[String, Person] =
    (
      validate[UserName](u),
      validate[Name](n),
      validate[Email](e)
    ).parMapN(Person.apply)

  object NewtypeRefinedOps {
    import io.estatico.newtype.Coercible
    import io.estatico.newtype.ops._

    final class NewtypeRefinedPartiallyApplied[A] {
      def apply[T, P](raw: T)(implicit c: Coercible[Refined[T, P], A], v: Validate[T, P]): EitherNel[String, A] =
        refineV[P](raw).toEitherNel.map(_.coerce[A])
    }

    def validate[A]: NewtypeRefinedPartiallyApplied[A] =
      new NewtypeRefinedPartiallyApplied[A]
  }
}
