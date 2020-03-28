import sbt.ThisBuild

// Global metadata.
ThisBuild / name := "scapass"
ThisBuild / organization := "net.rouly"
ThisBuild / licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
ThisBuild / maintainer := "michel@rouly.net"
ThisBuild / scalaVersion := "2.13.1"
ThisBuild / scalacOptions ++= ScalacOptions.recommended

lazy val commonSettings = Seq(
  name := "scapass-" + name.value,
)

lazy val noPublish = Seq(
  publishArtifact := false,
  publishLocal := {},
  publish := {},
)

// CLI application.
lazy val cli = project
  .enablePlugins(JavaAppPackaging, WindowsPlugin)
  .dependsOn(core)
  .settings(commonSettings)
  .settings(libraryDependencies += Dependencies.scopt)

// Core scapass application.
lazy val core = project
  .settings(commonSettings)
  .settings(libraryDependencies += Dependencies.bouncycastlePg)
