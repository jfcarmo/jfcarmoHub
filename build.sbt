name := """MithCRM"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  javaJpa,
  javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
  "org.hibernate" % "hibernate-entitymanager" % "4.3.5.Final",
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4"
)

//client libs
libraryDependencies ++= Seq(
  "org.webjars" % "bootstrap" % "3.2.0",
  "org.webjars" % "jquery" % "2.1.1",
  "org.webjars" % "angularjs" % "1.3.0-beta.8"
)


//modulos
libraryDependencies ++= Seq(
  "com.mohiva" %% "play-html-compressor" % "0.3"
)
