import sbt._
import Keys._
import NativePackagerHelper._

enablePlugins(SbtNativePackager)

enablePlugins(JavaAppPackaging)

enablePlugins(DockerPlugin)

name          := "service"

version       := "0.1-SNAPSHOT"

resolvers ++= Seq(
  "Spray repo" at "http://repo.spray.io/",
  "Typesafe repo" at "http://repo.typesafe.com/typesafe/releases"
)

libraryDependencies ++= {
  val akkaV = "2.3.9"
  val sprayV = "1.3.2"
  Seq(
    "io.spray"            %%  "spray-can"     % sprayV,
    "io.spray"            %%  "spray-routing" % sprayV,
    "io.spray"            %%  "spray-json"    % sprayV,
    "io.spray"            %%  "spray-testkit" % sprayV      % "test",
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV       % "test",
    "org.scalatest"       %%  "scalatest"     % "2.2.4",
    "com.gettyimages"     %%  "spray-swagger" % "0.5.1",
    "ch.qos.logback"      %   "logback-classic" % "1.1.2",
    "com.typesafe"        %   "config"          % "1.2.1"
  )
}

seq(Revolver.settings: _*)
