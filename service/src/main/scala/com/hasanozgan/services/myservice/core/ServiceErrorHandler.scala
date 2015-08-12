package com.hasanozgan.services.myservice.core

import spray.http.StatusCodes._
import spray.http.{HttpRequest, HttpResponse, Timedout}
import spray.routing.{ExceptionHandler, HttpServiceActor}
import spray.util.LoggingContext

/**
  * Created by hozgan on 06/08/15.
  */
trait ServiceErrorHandler extends HttpServiceActor {

   def handleTimeouts: Receive = {
     case Timedout(x: HttpRequest) =>
       sender ! HttpResponse(InternalServerError, "Something is taking way too long.")
   }

   implicit def serviceExceptions(implicit log: LoggingContext) =
     ExceptionHandler.apply {
       case e: Exception => {
         complete(InternalServerError, e.getMessage)
       }
     }
 }
