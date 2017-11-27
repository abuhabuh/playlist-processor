package com.fabricsounds.playlist.processor.format.flatfile
/**
  * Routes Parses the
  */

import com.fabricsounds.playlist.processor.PlaylistInfo

import akka.actor.Actor


class FlatfileParser extends Actor {

  def receive = {
    case plInfo: PlaylistInfo =>
      println("Got file info yay: " + plInfo + " - " + self.path)
  }
}
