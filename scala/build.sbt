val hedgehogVersion = "0.6.0"

name := "my-coding-training"

version := "0.1"

scalaVersion := "2.13.3"

resolvers += "bintray-scala-hedgehog" at "https://dl.bintray.com/hedgehogqa/scala-hedgehog"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.3" % Test,
  "qa.hedgehog" %% "hedgehog-core" % hedgehogVersion,
  "qa.hedgehog" %% "hedgehog-runner" % hedgehogVersion,
  "qa.hedgehog" %% "hedgehog-sbt" % hedgehogVersion
)

testFrameworks += TestFramework("hedgehog.sbt.Framework")