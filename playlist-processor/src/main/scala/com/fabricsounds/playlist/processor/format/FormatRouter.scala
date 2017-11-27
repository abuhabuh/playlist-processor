package com.fabricsounds.playlist.processor.format
/**
  * Routes playlists to other Routers that handle the right format
  */

import akka.actor.{Actor, Props}
import akka.routing.{ActorRefRoutee, RoundRobinRoutingLogic, Router}
import com.fabricsounds.playlist.processor.PlaylistInfo
import com.fabricsounds.playlist.processor.format.flatfile.FlatfileParser

class FormatRouter extends Actor {

  // Create workers for the router
  var router = {
    val routees = Vector.fill(5) {
      val routee = context.actorOf(Props[FlatfileParser])
      context watch routee
      ActorRefRoutee(routee)
    }
    Router(RoundRobinRoutingLogic(), routees)
  }

  def receive = {
    case plInfo: PlaylistInfo =>
      router.route(plInfo, sender())
      println("Routing Pl Info: " + plInfo)
  }
}
