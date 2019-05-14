// *****************************************************************************
// Projects
// *****************************************************************************

lazy val scalaIntro =
  project
    .in(file("."))
    .enablePlugins(AutomateHeaderPlugin)
    .settings(settings)
    .settings(
      libraryDependencies ++= Seq(
	library.catsCore,
	library.catsEffect,
	library.refined,
	library.refinedCats,
        library.scalaCheck % Test,
        library.scalaTest  % Test,
      )
    )

// *****************************************************************************
// Library dependencies
// *****************************************************************************

lazy val library =
  new {
    object Version {
      val cats       = "1.6.0"
      val catsEffect = "1.3.0"
      val refined    = "0.9.5"
      val scalaCheck = "1.14.0"
      val scalaTest  = "3.0.7"
    }
    val catsCore    = "org.typelevel"  %% "cats-core"    % Version.cats
    val catsEffect  = "org.typelevel"  %% "cats-effect"  % Version.catsEffect
    val refined     = "eu.timepit"     %% "refined"      % Version.refined
    val refinedCats = "eu.timepit"     %% "refined-cats" % Version.refined
    val scalaCheck  = "org.scalacheck" %% "scalacheck"   % Version.scalaCheck
    val scalaTest   = "org.scalatest"  %% "scalatest"    % Version.scalaTest
  }

// *****************************************************************************
// Settings
// *****************************************************************************

lazy val settings =
  commonSettings ++
  scalafmtSettings

lazy val commonSettings =
  Seq(
    scalaVersion := "2.12.8",
    organization := "com.wegtam",
    organizationName := "Wegtam GmbH",
    startYear := Some(2019),
    licenses += ("AGPL-3.0", url("https://www.gnu.org/licenses/agpl.html")),
    scalacOptions ++= Seq(
      "-deprecation",
      "-encoding", "UTF-8",
      "-explaintypes",
      "-feature",
      "-language:higherKinds",
      "-target:jvm-1.8",
      "-unchecked",
      "-Xcheckinit",
      "-Xfatal-warnings",
      "-Xfuture",
      "-Xlint:adapted-args",
      "-Xlint:by-name-right-associative",
      "-Xlint:constant",
      "-Xlint:delayedinit-select",
      "-Xlint:doc-detached",
      "-Xlint:inaccessible",
      "-Xlint:infer-any",
      "-Xlint:missing-interpolator",
      "-Xlint:nullary-override",
      "-Xlint:nullary-unit",
      "-Xlint:option-implicit",
      "-Xlint:package-object-classes",
      "-Xlint:poly-implicit-overload",
      "-Xlint:private-shadow",
      "-Xlint:stars-align",
      "-Xlint:type-parameter-shadow",
      "-Xlint:unsound-match",
      "-Ydelambdafy:method",
      "-Yno-adapted-args",
      "-Ypartial-unification",
      "-Ywarn-numeric-widen",
      "-Ywarn-unused-import",
      "-Ywarn-value-discard"
    ),
    Compile / console / scalacOptions --= Seq("-Xfatal-warnings", "-Ywarn-unused-import"),
    Compile / unmanagedSourceDirectories := Seq((Compile / scalaSource).value),
    Compile / compile / wartremoverWarnings ++= Warts.unsafe,
    Test / console / scalacOptions --= Seq("-Xfatal-warnings", "-Ywarn-unused-import"),
    Test / unmanagedSourceDirectories := Seq((Test / scalaSource).value)
)

lazy val scalafmtSettings =
  Seq(
    scalafmtOnCompile := true,
  )
