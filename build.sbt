import sbtassembly.AssemblyPlugin.autoImport._

name := "registers-scala-utils"

lazy val Versions = new {
  val play = "2.6.0-M4"
  val scala = "2.11.8"
  val scalatest = "3.0.1"
}

val sharedSettings: Seq[Def.Setting[_]] = Seq(
  organization := "uk.gov.ons",
  version := "1.0",
  scalaVersion := "2.11.8"
)

// import uk.gov.ons.util.test.ApiError

lazy val util = (project in file("."))
  .settings(sharedSettings: _*)
  .settings(
    name := "util",
    moduleName := "util"
  ).aggregate(play, general)

lazy val play = (project in file("util-play"))
  .settings(sharedSettings: _*)
  .settings(
    moduleName := "util-play",
    libraryDependencies ++= Seq(
      "com.typesafe.play"       %             "play_2.11"         %         "2.6.7",
      "org.scalatest"           %%            "scalatest"         %         Versions.scalatest % Test
    ),
    assemblyJarName in assembly := "util-play.jar",
    assemblyMergeStrategy in assembly := {
      case PathList("META-INF", xs @ _*) => MergeStrategy.discard
      case x => MergeStrategy.first
    }
  )

lazy val general = (project in file("util-general"))
  .settings(sharedSettings: _*)
  .settings(
    moduleName := "util-general",
    libraryDependencies ++= Seq(
      "org.scalatest"           %%            "scalatest"         %         Versions.scalatest % Test
    ),
    assemblyJarName in assembly := "util-general.jar",
    assemblyMergeStrategy in assembly := {
      case PathList("META-INF", xs @ _*) => MergeStrategy.discard
      case x => MergeStrategy.first
    }
  )