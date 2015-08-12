package com.hasanozgan.services.myservice.httpservices.models

import spray.httpx.SprayJsonSupport
import spray.json.DefaultJsonProtocol


object UserProtocol extends DefaultJsonProtocol with SprayJsonSupport {
  implicit val userFormat = jsonFormat2(User)
}

case class User(username: String, password: String)