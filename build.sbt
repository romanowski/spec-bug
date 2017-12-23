import sbt.TestFrameworks.Specs2

import scala.collection.Seq

name := "specs-bug"

version := "0.1"

scalaVersion := "2.12.4"

// Change to 4.0.0 to fix performance
libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "4.0.0" % "test")

scalacOptions in Test ++= Seq("-Yrangepos")

testOptions in Test := Seq(Tests.Argument(Specs2, "showtimes", "exclude", "ala"))

