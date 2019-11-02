name := "http4s-zio"

version := "0.1"

scalaVersion := "2.12.10"

val Http4sVersion = "0.20.11"
val CirceVersion = "0.12.3"
val ZioVersion = "1.0.0-RC16"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-blaze-server" % Http4sVersion,
  "org.http4s" %% "http4s-blaze-client" % Http4sVersion,
  "org.http4s" %% "http4s-circe" % Http4sVersion,
  "org.http4s" %% "http4s-dsl" % Http4sVersion,
  "io.circe" %% "circe-generic" % CirceVersion,
  "dev.zio" %% "zio" % "1.0.0-RC16",
  "dev.zio" %% "zio-interop-cats" % "2.0.0.0-RC6",

)
