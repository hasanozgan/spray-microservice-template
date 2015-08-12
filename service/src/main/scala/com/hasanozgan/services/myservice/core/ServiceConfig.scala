package com.hasanozgan.services.myservice.core

import com.typesafe.config.ConfigFactory

/**
  * Created by hozgan on 06/08/15.
  */
object ServiceConfig {
   private val config = ConfigFactory.load()

   object HttpConfig {
     private val httpConfig = config.getConfig("http")
     lazy val interface = httpConfig.getString("interface")
     lazy val port = httpConfig.getInt("port")
   }
 }
