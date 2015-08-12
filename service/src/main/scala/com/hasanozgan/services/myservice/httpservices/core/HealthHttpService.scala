package com.hasanozgan.services.myservice.httpservices.core

import akka.actor.Props
import akka.pattern.ask
import akka.util.Timeout
import com.hasanozgan.services.myservice.actors.HealthActor
import org.json4s.ShortTypeHints
import org.json4s.native.Serialization
import spray.routing._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

trait HealthHttpService extends HttpService {

  implicit val timeout = Timeout(5 seconds)

  lazy val healthActor = actorRefFactory.actorOf(Props(new HealthActor()))

  private implicit val formats = Serialization.formats(ShortTypeHints(List(classOf[List[Int]])))

  final val routes =
  pathPrefix("health") {
    path("ping") {
      get {
        onSuccess(healthActor ? "ping") {
          case x:String => complete(x)
          case _ => complete("error")
        }
      }
    }
  }
}