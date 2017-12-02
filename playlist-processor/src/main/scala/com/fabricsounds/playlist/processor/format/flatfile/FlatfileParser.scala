package com.fabricsounds.playlist.processor.format.flatfile
/**
  * Routes Parses the
  */

import com.fabricsounds.playlist.processor.PlaylistInfo

import akka.actor.Actor
import scalaj.http._


class FlatfileParser extends Actor {

  def receive = {
    case plInfo: PlaylistInfo =>
      println("Got file info yay: " + plInfo + " - " + self.path + " - sender: " + sender())
      val request: HttpRequest = Http("http://date.jsontest.com/")

      println(request.asString)
  }
}
