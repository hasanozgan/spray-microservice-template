package com.hasanozgan.services.myservice.actors

import akka.actor.Actor
import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory
import spray.routing.RequestContext

class HealthActor extends Actor {
  val logger = Logger(LoggerFactory.getLogger(this.getClass))

  def receive = {
    case "ping" =>
      logger.debug("beni cagirdin. aferin..")
      sender ! "pong"
    case ctx: RequestContext => ctx.complete("Welcome to Amber Gold!")
  }
}