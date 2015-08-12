package com.hasanozgan.services.myservice.client

import spray.client.pipelining._
import akka.pattern.pipe
import UserProtocol._

class UserServiceActor extends ClientServiceActor {

  import context.dispatcher

  val pipeline = sendReceive ~> unmarshal[User]

  override def receive: Receive = {
    case GetUsers() =>
      pipeline(Get(makeUrl("/users"))) pipeTo sender

    case GetUser(username: String) =>
      pipeline(Get(makeUrl(s"/user/$username"))) pipeTo sender
  }
}

case class GetUser(username: String)

case class GetUsers()
