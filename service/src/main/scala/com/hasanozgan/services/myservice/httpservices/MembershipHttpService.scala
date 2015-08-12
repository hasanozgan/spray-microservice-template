package com.hasanozgan.services.myservice.httpservices

import akka.util.Timeout
import com.hasanozgan.services.myservice.httpservices.models.User
import com.hasanozgan.services.myservice.httpservices.models.UserProtocol._
import spray.routing._
import scala.concurrent.duration._


trait MembershipHttpService extends HttpService {

  implicit def executionContext = actorRefFactory.dispatcher
  implicit val timeout = Timeout(5 seconds)

  val routes = pathPrefix("membership") {
    signIn ~ signUp
  }

  def signIn = post { path("login") { formFields('username, 'password) { (username, password) =>
    complete(s"$username")
  }}}

  def signUp = post { path("register") { entity(as[User]) { user =>
    complete(s"$user")
  }}}
}
