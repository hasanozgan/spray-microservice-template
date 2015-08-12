package com.hasanozgan.services.myservice.client

import akka.actor.Actor
import spray.client.pipelining._
import spray.httpx.SprayJsonSupport
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by hozgan on 12/08/15.
 */
trait ClientServiceActor extends Actor with Config with SprayJsonSupport {
  /* Example pipeline
  val pipeline: HttpRequest => Future[OrderConfirmation] = (
    addHeader("X-My-Special-Header", "fancy-value")
    ~> addCredentials(BasicHttpCredentials("bob", "secret"))
    ~> encode(Gzip)
    ~> sendReceive
    ~> decode(Deflate)
    ~> unmarshal[OrderConfirmation]
  )
  */
  //val pipeline = sendReceive
}