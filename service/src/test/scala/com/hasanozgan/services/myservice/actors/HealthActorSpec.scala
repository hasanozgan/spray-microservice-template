package com.hasanozgan.services.myservice.actors

import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, DefaultTimeout, TestKit}
import com.typesafe.config.ConfigFactory
import org.scalatest.{BeforeAndAfterAll, Matchers, WordSpecLike}

import scala.concurrent.duration._

/**
 * Created by hozgan on 07/08/15.
 */
class HealthActorSpec extends TestKit(ActorSystem("HealthActorSpec", ConfigFactory.parseString("""akka { loglevel = "WARNING" }""")))
                        with DefaultTimeout with ImplicitSender
                        with WordSpecLike with Matchers with BeforeAndAfterAll
{
  lazy val helloActor = system.actorOf(Props(new HealthActor()))

  override def afterAll() {
    shutdown()
  }

  "An HelloActor" should {
    "Respond with the same message it receives" in {
      within(500 millis) {
        helloActor ! "ping"
        expectMsg("pong")
      }
    }
  }

}
