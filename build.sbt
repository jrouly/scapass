import sbt.ThisBuild

// Global metadata.
ThisBuild / name := "scapass"
ThisBuild / organization := "net.rouly"
ThisBuild / licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
ThisBuild / maintainer := "michel@rouly.net"
ThisBuild / scalaVersion := "2.13.1"
ThisBuild / scalacOptions ++= ScalacOptions.recommended
ThisBuild / resolvers += Release.bintrayResolver
ThisBuild / publishTo := Some(Release.bintrayResolver)

// Disable publishing for root project.
publishArtifact := false
publishLocal := {}
publish := {}

lazy val commonSettings = Seq(
  name := "scapass-" + name.value,
) ++ Release.bintraySettings

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
