package com.hasanozgan.services.myservice.client

import com.typesafe.config.ConfigFactory

/**
 * Created by hozgan on 12/08/15.
 */
trait Config {
  private val config = ConfigFactory.load()
  private val service = config.getConfig("my-service")
  private val myServiceURL = service.getString("baseUrl")

  def makeUrl(path:String) = myServiceURL + path

}
