organization := "eu.getintheloop"

version      := "0.0.9"

name 				 := "lift-shiro"

scalaVersion := "2.10.0"

resolvers ++= Seq(
      "CB Central Mirror" at "http://repo.cloudbees.com/content/groups/public",
      "Shiro Releases" at "https://repository.apache.org/content/repositories/releases/",
      "Shiro Snapshots" at "https://repository.apache.org/content/repositories/snapshots/",
      "sonatype.repo" at "https://oss.sonatype.org/content/repositories/public/"
    )

scalacOptions <<= scalaVersion map { v: String =>
      val opts = "-deprecation" :: "-unchecked" :: Nil
      if (v.startsWith("2.9.")) opts else opts ++ ( "-language:implicitConversions" :: "-language:postfixOps" :: Nil)}

crossScalaVersions := Seq("2.10.4", "2.11.5")

licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0.html"))

seq(bintrayPublishSettings: _*)

libraryDependencies ++= Seq(
  "org.apache.shiro"  % "shiro-core"          % "1.2.3",
  "org.apache.shiro"  % "shiro-web"           % "1.2.3",
  "commons-beanutils" % "commons-beanutils"   % "1.9.2",
  "net.liftweb" 			%% "lift-webkit" 				% "2.6"			% "provided"
)
