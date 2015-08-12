package com.hasanozgan.services.myservice.client

import spray.client.pipelining._
import akka.pattern.pipe
import UserProtocol._

class MembershipServiceActor extends ClientServiceActor {
  import context.dispatcher

  val pipeline = sendReceive ~> unmarshal[User]

  override def receive: Receive = {
    case RegisterUser(username: String, password: String) =>
      registerUser(username, password) pipeTo sender

    case LoginUser(username: String, password: String) =>
      registerUser(username, password) pipeTo sender
  }

  def registerUser(username: String, password: String) = {
    pipeline(Post(makeUrl("/membership/register"), User(username, password)))
  }

  def loginUser(username: String, password: String) = {
    pipeline(Post(makeUrl("/membership/login"), User(username, password)))
  }
}

case class RegisterUser(username: String, password: String)

case class LoginUser(username: String, password: String)
