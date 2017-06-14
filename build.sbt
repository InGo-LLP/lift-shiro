organization := "eu.getintheloop"

version      := "0.0.9-ingo2"

name 				 := "lift-shiro"

scalaVersion := "2.12.2"

resolvers ++= Seq(
      "CB Central Mirror" at "http://repo.cloudbees.com/content/groups/public",
      "Shiro Releases" at "https://repository.apache.org/content/repositories/releases/",
      "Shiro Snapshots" at "https://repository.apache.org/content/repositories/snapshots/",
      "sonatype.repo" at "https://oss.sonatype.org/content/repositories/public/"
    )

scalacOptions <<= scalaVersion map { v: String =>
      val opts = "-deprecation" :: "-unchecked" :: Nil
      if (v.startsWith("2.9.")) opts else opts ++ ( "-language:implicitConversions" :: "-language:postfixOps" :: Nil)}

crossScalaVersions := Seq("2.11.11", "2.12.2")

licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0.html"))

seq(bintrayPublishSettings: _*)

libraryDependencies ++= Seq(
  "org.apache.shiro"  % "shiro-core"          % "1.4.0",
  "org.apache.shiro"  % "shiro-web"           % "1.4.0",
  "net.liftweb" 			%% "lift-webkit" 				% "3.0.1"			% "provided"
)
