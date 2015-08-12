package com.hasanozgan.services.myservice.core

import spray.routing.HttpServiceActor

/**
 * Created by hozgan on 06/08/15.
 */
class ServiceActor extends HttpServiceActor
                      with ServiceRouteHandler
                      with ServiceRejectionHandler
                      with ServiceErrorHandler
{
  override def actorRefFactory = context

  override def receive: Receive =
                                  runRoute(handleRejections(serviceRejections)
                                          (handleExceptions(serviceExceptions)
                                          (serviceRoutes)))
}
