package com.hasanozgan.services.myservice.core

import akka.actor.ActorRefFactory
import com.gettyimages.spray.swagger.SwaggerHttpService
import com.hasanozgan.services.myservice.httpservices.{MembershipHttpService, UserHttpService}
import com.hasanozgan.services.myservice.httpservices.core.{HealthHttpService, SwaggerUIHttpService}
import com.wordnik.swagger.model.ApiInfo
import spray.routing.HttpServiceActor

import scala.reflect.runtime.universe.typeOf

/**
  * Created by hozgan on 06/08/15.
  */
trait ServiceRouteHandler extends HttpServiceActor {

  override def actorRefFactory = context

  val apiDoc = new SwaggerHttpService {
    override def actorRefFactory = context

    override def apiTypes = Seq(typeOf[UserHttpService], typeOf[MembershipHttpService])
    override def apiVersion = "2.0"
    override def baseUrl = "/" // let swagger-ui determine the host and port
    override def docsPath = "api-docs"
    override def apiInfo = Some(new ApiInfo("My Service", "A sample micro service using spray.", "http://hasanozgan.com/toc.html", "hasan@ozgan.net", "Apache v2", "http://www.apache.org/licenses/LICENSE-2.0"))
  }

  val swaggerUI = new SwaggerUIHttpService {
    def actorRefFactory = context
  }

  val healthService = new HealthHttpService {
    def actorRefFactory = context
  }

  val userService = new UserHttpService {
    def actorRefFactory = context
  }

  val membershipService = new MembershipHttpService {
    def actorRefFactory = context
  }

   def serviceRoutes = apiDoc.routes ~ swaggerUI.routes ~ healthService.routes ~
                         userService.routes ~
                         membershipService.routes
 }
