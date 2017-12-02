package com.fabricsounds.playlist.processor.format
/**
  * Routes playlists to other Routers that handle the right format
  */

import akka.actor.{Actor, Props}
import akka.routing.{RoundRobinPool}
import com.fabricsounds.playlist.processor.PlaylistInfo
import com.fabricsounds.playlist.processor.format.flatfile.FlatfileParser

class FormatRouter extends Actor {

  val flatfileParserRouter = context.actorOf(
    Props[FlatfileParser].withRouter(RoundRobinPool(nrOfInstances = 5)),
    name = "FlatFileParserRouter")

  def receive = {
    case plInfo: PlaylistInfo =>
      flatfileParserRouter.forward(plInfo)
      println("Routing Pl Info: " + plInfo)
  }
}
