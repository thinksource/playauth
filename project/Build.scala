import sbt._
import Keys._
import play.Project._
import com.github.play2war.plugin._
import scala.xml._
import com.googlecode.flyway.sbt.FlywayPlugin._
object ApplicationBuild extends Build {

    val appName         = "playauth"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
       jdbc, 
	     javaJdbc,
  javaEbean,
  cache,
  "org.mindrot" % "jbcrypt" % "0.3m",
      "be.objectify" %% "deadbolt-java" % "2.2-RC4",
	  "org.reactivemongo" %% "play2-reactivemongo" % "0.10.2",
//	  "be.objectify" %% "deadbolt-java" % "2.2-RC4",
	  "be.objectify" %% "deadbolt-scala" % "2.2-RC2",
	  "postgresql" % "postgresql" % "9.1-901.jdbc4",
	  "org.webjars" %% "webjars-play" % "2.2.1-2",
	  "org.webjars" % "bootstrap" % "3.1.1",
	  "com.typesafe.slick" %% "slick" % "2.0.1",
	  "org.slf4j" % "slf4j-nop" % "1.6.4",
	  "org.scalatest" %% "scalatest" % "2.0",
//	  "com.vividsolutions" % "jts" % "1.11",
//	  "com.github.tminglei" % "slick-pg_2.10" % "0.5.2.3",
	   "com.typesafe.play" %% "play-slick" % "0.6.0.1",
	   "joda-time"%"joda-time"%"2.3",
	   "org.joda" % "joda-convert" % "1.6",
		"jp.t2v" %% "play2-auth"      % "0.11.0",
	   "org.scalikejdbc" %% "scalikejdbc"               % "1.7.5",
      "org.scalikejdbc" %% "scalikejdbc-interpolation" % "1.7.5",
	  "org.scalikejdbc"   %% "scalikejdbc-play-plugin"    % "1.7.5",
//      "com.h2database"  %  "h2"                        % "[1.3,)",
      "ch.qos.logback"  %  "logback-classic"           % "[1.1,)",
	   "com.github.tototoshi" %% "slick-joda-mapper" % "1.0.1",
	   "com.github.tototoshi" %% "play-flyway"                % "1.0.3"
    )
    play.Project.playScalaSettings
    
    val logLevel = Level.Debug
    
    val main = play.Project(appName, appVersion, appDependencies)
    .settings(Play2WarPlugin.play2WarSettings: _*)
    .settings(Play2WarKeys.servletVersion := "3.0")
	.settings(flywaySettings: _*)
	.settings(flywayUrl := "jdbc:postgresql://localhost:5432/authexample")
	.settings(flywayUser := "postgres")
	.settings(flywayPassword := "postgres")
    .settings(
      // Change this to point to your local play repository
      resolvers += Resolver.url("Objectify Play Repository", url("http://schaloner.github.com/releases/"))(Resolver.ivyStylePatterns),
      resolvers += Resolver.url("Objectify Play Repository - snapshots", url("http://schaloner.github.com/snapshots/"))(Resolver.ivyStylePatterns),
	  //resolvers += Resolver.url("Sonatype Snapshots",url("http://oss.sonatype.org/content/repositories/snapshots/"))(Resolver.ivyStylePatterns),
      resolvers += "typesafe" at "http://repo.typesafe.com/typesafe/release",
      resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
	  
    )

}