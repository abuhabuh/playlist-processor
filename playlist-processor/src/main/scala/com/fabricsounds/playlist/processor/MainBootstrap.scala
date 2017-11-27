package com.fabricsounds.playlist.processor
/**
  * Main bootstrap class for initializing cluster
  */

import akka.actor.ActorSystem
import akka.actor.Props

import client.PlayListClient


object MainBootstrap {
  def main(args: Array[String]): Unit = {
    startup()
  }

  def startup(): Unit = {
    println("=== Startup ===");

    // todo: extract system name / add config
    val system = ActorSystem("PlaylistProcessorSystem")

    val clientActor = system.actorOf(Props[PlayListClient], "PlaylistClient")
  }
}
