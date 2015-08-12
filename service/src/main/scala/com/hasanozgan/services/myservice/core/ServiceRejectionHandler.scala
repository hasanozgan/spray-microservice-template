package com.hasanozgan.services.myservice.core

import spray.http.StatusCodes._
import spray.routing.{HttpService, RejectionHandler}

/**
  * Created by hozgan on 06/08/15.
  */
trait ServiceRejectionHandler extends HttpService {
   implicit val serviceRejections = RejectionHandler {
     case SecurePageRejection(uri) :: rejectionsTail => complete(BadRequest, s"error + ${uri.path}")

     case x => complete(BadRequest, x.toString())
   }
 }
