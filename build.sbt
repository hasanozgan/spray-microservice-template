lazy val commonSettings = Seq(
  organization := "com.hasanozgan",
  version := "1.0-SNAPSHOT",
  scalaVersion  := "2.11.6",
  scalacOptions := Seq(
    "-unchecked",
    "-deprecation",
    "-encoding", "utf8",
    "-feature",
    "-language:postfixOps",
    "-language:implicitConversions",
    "-language:existentials"))

mainClass in Compile := Some("com.hasanozgan.services.myservice.Boot")

lazy val assemblySettings = Seq(
)

lazy val settings = (
  commonSettings
  ++ assemblySettings)

lazy val publishSettings = Seq(
  publishMavenStyle := true,
  publishArtifact in Test := false,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases"  at nexus + "service/local/staging/deploy/maven2")
  },
  pomExtra := (
    <url>http://github.com/hasanozgan/microservice-template</url>
      <licenses>
        <license>
          <name>Apache 2</name>
          <url>http://www.apache.org/licenses/LICENSE-2.0</url>
          <distribution>repo</distribution>
        </license>
      </licenses>
      <scm>
        <url>git@github.com:hasanozgan/microservice-template.git</url>
        <connection>scm:git@github.com:hasanozgan/microservice-template.git</connection>
      </scm>
      <developers>
        <developer>
          <id>hasanozgan</id>
          <name>Hasan Ozgan</name>
          <url>http://github.com/hasanozgan</url>
        </developer>
      </developers>))

lazy val root = project.in( file(".") )
  .aggregate(service, client).dependsOn()

lazy val client = project.in(file("client"))
  .settings(settings: _*)
  .settings(publishSettings: _*)
  .settings(test in assembly := {})
  .settings(testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-oDF"))

lazy val service = project.in(file("service"))
  .dependsOn(client)
  .settings(settings: _*)
  .settings(publishSettings: _*)
  .settings(test in assembly := {})
  .settings(testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-oDF"))
