lazy val commonSettings = Seq(
  organization := "io.icednut.akka.exercise.bookstore",
  version := "0.0.1",
  scalaVersion := "2.13.3"
)

lazy val common = (project in file("common")).settings(commonSettings: _*)
lazy val bookServices = (project in file("book-services")).settings(commonSettings: _*).dependsOn(common)
lazy val userServices = (project in file("user-services")).settings(commonSettings: _*).dependsOn(common)
lazy val creditServices = (project in file("credit-services")).settings(commonSettings: _*).dependsOn(common)
lazy val orderServices = (project in file("order-services")).settings(commonSettings: _*).dependsOn(common)

lazy val server = {
  import com.typesafe.sbt.packager.docker._
  Project(
    id = "server",
    base = file("server")
  ).settings(
    ss = commonSettings ++ Seq(
      mainClass := Some("io.icednut.akka.exercise.bookstore.server.Server"),
      dockerCommands := dockerCommands.value.filterNot {
        case Cmd("USER", args@_*) => true
        case cmd => false
      },
      version in Docker := "latest",
      dockerExposedPorts := Seq(8080),
      maintainer in Docker := "wglee21g@gmail.com",
      dockerBaseImage := "java:8"
    )
  )
    .dependsOn(common, bookServices, userServices, creditServices, orderServices)
    .enablePlugins(JavaAppPackaging)
}

//lazy val root = (project in file(".")).
//  settings(
//    inThisBuild(List(
//      organization    := "example",
//      scalaVersion    := "2.13.3"
//    )),
//    name := "step_1_start_book_store",
//    libraryDependencies ++= Seq(
//      "com.typesafe.akka" %% "akka-http"                % akkaHttpVersion,
//      "com.typesafe.akka" %% "akka-http-spray-json"     % akkaHttpVersion,
//      "com.typesafe.akka" %% "akka-actor-typed"         % akkaVersion,
//      "com.typesafe.akka" %% "akka-stream"              % akkaVersion,
//      "ch.qos.logback"    % "logback-classic"           % "1.2.3",
//
//      "com.typesafe.akka" %% "akka-http-testkit"        % akkaHttpVersion % Test,
//      "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaVersion     % Test,
//      "org.scalatest"     %% "scalatest"                % "3.0.8"         % Test
//    )
//  )

lazy val root = (project in file("."))
  .aggregate(common, bookServices, userServices, creditServices, orderServices, server)