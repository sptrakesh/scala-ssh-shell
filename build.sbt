libraryDependencies <++= (scalaVersion) {
	(scala) => Seq(
	"org.scala-lang" % "scala-compiler" % scala,
	"org.scala-lang" % "jline" % scala,
	"com.weiglewilczek.slf4s" %% "slf4s" % "1.0.7",
	"org.slf4j" % "slf4j-simple" % "1.6.2",
	"org.apache.sshd" % "apache-sshd" % "0.6.0"
	)}

