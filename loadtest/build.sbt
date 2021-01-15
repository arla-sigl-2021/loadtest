import Dependencies._

enablePlugins(GatlingPlugin)

lazy val root = (project in file("."))
  .settings(
    inThisBuild(List(
      organization := "fr.arlasigl",
      scalaVersion := "2.13.4",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "loadtest",
    libraryDependencies ++= gatling
  )
