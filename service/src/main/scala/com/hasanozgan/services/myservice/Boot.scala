package com.hasanozgan.services.myservice

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import akka.util.Timeout
import com.hasanozgan.services.myservice.core.{ServiceConfig, ServiceActor}
import spray.can.Http
import scala.concurrent.duration._
import akka.pattern.ask

/**
 * Created by hozgan on 10/08/15.
 */
object Boot extends App {

   // we need an ActorSystem to host our application in
   implicit val system = ActorSystem("on-spray-can")

   // create and start our service actor
   val serviceActor = system.actorOf(Props[ServiceActor], "my-service")

   implicit val timeout = Timeout(5.seconds)

   // start a new HTTP server on port 8080 with our service actor as the handler
   IO(Http) ? Http.Bind(serviceActor, interface = ServiceConfig.HttpConfig.interface, port = ServiceConfig.HttpConfig.port)
 }
