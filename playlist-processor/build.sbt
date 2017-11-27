import Dependencies._


val akkaVersion = "2.5.4"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      name := "PlaylistProcessor",
      organization := "com.fabricsounds",
      scalaVersion := "2.12.3",
      version      := "0.0.1"
    )),

    libraryDependencies += scalaTest % Test,
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor" % akkaVersion,
      "com.typesafe.akka" %% "akka-remote" % akkaVersion,
      "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
      "com.typesafe.akka" %% "akka-cluster-metrics" % akkaVersion,
      "com.typesafe.akka" %% "akka-cluster-tools" % akkaVersion,
      "com.typesafe.akka" %% "akka-multi-node-testkit" % akkaVersion,
    )
  )
