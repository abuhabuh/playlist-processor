package com.fabricsounds.playlist.processor
/**
  * Main bootstrap class for initializing cluster
  */

import akka.actor.ActorSystem
import akka.actor.Props
import client.PlayListClient
import com.typesafe.config.ConfigFactory


object MainBootstrap {
  def main(args: Array[String]): Unit = {
    startup()
  }

  def startup(): Unit = {
    println("=== Startup ===");

    val configuration = ConfigFactory.load()
    val system = ActorSystem(
      configuration.getString("const.system_name"), configuration)

    val clientActor = system.actorOf(Props[PlayListClient], "PlaylistClient")
  }
}
