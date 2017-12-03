import Dependencies._


val akkaVersion = "2.5.4"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      name := "PlaylistProcessor",
      packageName := "playlist-demo",
      organization := "com.fabricsounds",
      scalaVersion := "2.12.3",
      version      := "0.0.2"
    )),

    libraryDependencies += scalaTest % Test,
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor" % akkaVersion,
      "com.typesafe.akka" %% "akka-remote" % akkaVersion,
      "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
      "com.typesafe.akka" %% "akka-cluster-metrics" % akkaVersion,
      "com.typesafe.akka" %% "akka-cluster-tools" % akkaVersion,
      "com.typesafe.akka" %% "akka-multi-node-testkit" % akkaVersion
    ),
    libraryDependencies ++= Seq(
      "org.scalaj" %% "scalaj-http" % "2.3.0"
    )
  ).enablePlugins(JavaAppPackaging)

dockerRepository := Some("johnwang412")
dockerBaseImage := "anapsix/alpine-java:latest"
dockerUpdateLatest := true
