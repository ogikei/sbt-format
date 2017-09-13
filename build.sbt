lazy val commonSettings = Seq(
  version := "0.1",
  scalaVersion := "2.11.11",
  libraryDependencies ++= Seq(
    "org.apache.spark" %% "spark-core" % "2.2.0",
    "org.apache.spark" %% "spark-mllib" % "2.2.0")
)

lazy val structuredStreamingSettings = Seq(
  libraryDependencies ++= Seq(
    "org.apache.spark" %% "spark-streaming" % "2.2.0")
)

lazy val sparkStreamingSettings = Seq(
  libraryDependencies ++= Seq(
    "org.apache.spark" %% "spark-sql" % "2.2.0")
)

lazy val root = (project in file("."))
  .aggregate(structuredStreaming, sparkStreaming)
  .settings(
    commonSettings,
    name := "root"
  )

lazy val structuredStreaming = (project in file("structured-streaming"))
  .settings(
    commonSettings,
    structuredStreamingSettings,
    name := "structured-streaming"
  )

lazy val sparkStreaming = (project in file("spark-streaming"))
  .settings(
    commonSettings,
    sparkStreamingSettings,
    name := "spark-streaming"
  )

