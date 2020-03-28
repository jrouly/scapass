import sbt._

object Dependencies {

  // Multi-artifact dependencies.
  // A-Z please.
  private def bouncycastle(artifact: String) =
    "org.bouncycastle" % artifact % "1.64"

  // A-Z please.
  val bouncycastlePg = bouncycastle("bcpg-jdk15to18")
  val scopt = "com.github.scopt" %% "scopt" % "4.0.0-RC2"

}
