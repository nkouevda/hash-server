organization := "com.nkouevda"
name := "hash-server"
version := "0.0.1-SNAPSHOT"

scalaVersion := "2.12.8"

val logbackVersion = "1.2.3"
val comTwitterFinatraVersion = "20.12.0"

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % logbackVersion,
  "com.twitter" %% "finatra-http" % comTwitterFinatraVersion,
)
