lazy val hedgehogVersion = "0.6.0"

name := "my-coding-training"

version := "0.1"

scalaVersion := "2.13.5"

resolvers += "bintray-scala-hedgehog" at "https://dl.bintray.com/hedgehogqa/scala-hedgehog"

libraryDependencies ++= Seq(
  compilerPlugin(
    "org.typelevel" %% "kind-projector" % "0.12.0" cross CrossVersion.full
  ),
  "org.typelevel" %% "cats-core" % "2.6.1",
  "org.typelevel" %% "cats-effect" % "3.1.1",
  "org.typelevel" %% "cats-mtl" % "1.2.1",
  "co.fs2" %% "fs2-core" % "3.0.3",
  "dev.optics" %% "monocle-core" % "3.0.0",
  "dev.optics" %% "monocle-macro" % "3.0.0",
  "io.estatico" %% "newtype" % "0.4.4",
  "eu.timepit" %% "refined" % "0.9.25",
  "eu.timepit" %% "refined-cats" % "0.9.25",
  "tf.tofu" %% "derevo-cats" % "0.12.5",
  "tf.tofu" %% "derevo-cats-tagless" % "0.12.5",
  "tf.tofu" %% "derevo-circe-magnolia" % "0.12.5",
  "tf.tofu" %% "tofu-core-higher-kind" % "0.10.2",

  "dev.profunktor" %% "redis4cats-effects" % "1.0.0",

  // Test
  "qa.hedgehog" %% "hedgehog-core" % hedgehogVersion,
  "qa.hedgehog" %% "hedgehog-runner" % hedgehogVersion,
  "qa.hedgehog" %% "hedgehog-sbt" % hedgehogVersion,
  "org.scalatest" %% "scalatest" % "3.2.3" % Test
)

scalacOptions ++= Seq(
  "-Ymacro-annotations", "-Wconf:cat=unused:info"
)

testFrameworks += TestFramework("hedgehog.sbt.Framework")
