name := "scala-ssh-shell"

organization := "scala-ssh-shell"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.9.1"

retrieveManaged := true

libraryDependencies <++= (scalaVersion) {
	(scala) => Seq(
	"org.scala-lang" % "scala-compiler" % scala,
	"org.scala-lang" % "jline" % scala,
	"com.weiglewilczek.slf4s" %% "slf4s" % "1.0.7",
	"org.slf4j" % "slf4j-simple" % "1.6.2",
	"org.apache.sshd" % "apache-sshd" % "0.6.0"
	)}

