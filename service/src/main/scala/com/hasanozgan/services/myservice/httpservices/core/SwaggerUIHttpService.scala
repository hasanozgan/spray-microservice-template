package com.hasanozgan.services.myservice.httpservices.core

import spray.routing.HttpService

/**
 * Created by hozgan on 06/08/15.
 */
trait SwaggerUIHttpService extends HttpService {
  final val routes =
    get {
      pathPrefix("") { pathEndOrSingleSlash {
        getFromResource("swagger-ui/index.html")
      }
    } ~
    getFromResourceDirectory("swagger-ui")
  }
}
