name := "bookstore-common"
lazy val akkaHttpVersion = "10.2.2"
lazy val akkaVersion = "2.6.10"
lazy val slickVersion = "3.3.3"

libraryDependencies ++= Seq(
  // akka
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,

  // logging
  "ch.qos.logback" % "logback-classic" % "1.2.3",

  // database
  "com.typesafe.slick" %% "slick" % slickVersion,
  "org.postgresql" % "postgresql" % "42.2.2",

  // test
  "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test,
  "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaVersion % Test,
  "org.scalatest" %% "scalatest" % "3.0.8" % Test
)