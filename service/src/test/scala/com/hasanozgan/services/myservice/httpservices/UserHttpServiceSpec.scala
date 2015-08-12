package com.hasanozgan.services.myservice.httpservices

import com.hasanozgan.services.myservice.httpservices.models.User
import org.scalatest.{Matchers, FreeSpec}
import spray.http.StatusCodes
import spray.routing.Directives
import spray.testkit.ScalatestRouteTest

/**
 * Created by hozgan on 10/08/15.
 */
class UserHttpServiceSpec extends FreeSpec with Matchers with Directives with ScalatestRouteTest with UserHttpService {

  def actorRefFactory = system

  "The UserService should support" - {
    "GET /user/:username should work" in {
      Get("/user/hasanozgan") ~> routes ~> check {
        handled should be (right = true)
        status should be (StatusCodes.OK)
      }
    }
  }

}
