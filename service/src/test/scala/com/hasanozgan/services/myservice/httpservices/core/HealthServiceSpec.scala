package com.hasanozgan.services.myservice.httpservices.core

import org.scalatest.{FreeSpec, Matchers}
import spray.http._
import spray.routing.Directives
import spray.testkit.ScalatestRouteTest

class HealthServiceSpec  extends FreeSpec with Matchers with Directives with ScalatestRouteTest with HealthHttpService {
  def actorRefFactory = system

  "The ScalatestRouteTest should support" - {
    "GET /ping should work" in {
      Get("/health/ping") ~> routes ~> check {
        handled should be (right = true)
        status should be (StatusCodes.OK)
        responseAs[String] should equal ("pong")
      }
    }
  }
}
