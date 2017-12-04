package com.fabricsounds.playlist.processor.client
/**
  * Client actor that takes playlist processing requests
  *
  * Playlist taxonomy:
  *   1. medium (webpage, txt file, etc)
  *   2.
  */

import com.fabricsounds.playlist.processor.{PlaylistInfo, Tick}

import scala.concurrent.duration._
import akka.actor.{Actor, Props}
import akka.routing.FromConfig
import com.fabricsounds.playlist.processor.format.flatfile.FlatfileParser


class PlaylistClient extends Actor {

  // todo: dunno why i need context.dispatcher imported
  import context.dispatcher

  val tickTask = context.system.scheduler.schedule(2.seconds, 2.seconds, self, Tick)

  val formatRouter = context.actorOf(FromConfig.props(Props[FlatfileParser]), "FormatRouter")

  def receive = {
    case Tick =>
      println("CLIENT [" + self.path + "] -- tick")
      formatRouter ! PlaylistInfo("hello")
  }

}
