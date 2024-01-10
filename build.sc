import mill._
import mill.api.Loose.Agg
import mill.scalalib._
import coursier.core.ModuleName
import coursier.Module
import coursier.Organization
import mill.define.Command
import mill.scalalib.publish.License
import mill.scalalib.publish.PomSettings
import mill.scalalib.publish.VersionControl
import mill.scalalib.PublishModule
import mill.T

object versions {
    val scala = "3.3.0"
}

trait LibModule extends PublishModule {
    override def pomSettings: T[PomSettings] = PomSettings(
        description = artifactName(),
        organization = "com.github.yakivy",
        url = "https://github.com/yakivy/mill-issue-2914",
        licenses = Seq(License.Unlicense),
        versionControl = VersionControl.apply(),
        developers = Seq()
    )
}

object service1 extends ScalaModule {
    override def scalaVersion = versions.scala

    override def ivyDeps = T(Agg(
        ivy"com.github.yakivy::api2:0.0.1",
    ))

    override def moduleDeps = Seq(api1)
}

object api1 extends ScalaModule with LibModule {
    override def artifactName = "api1"
    override def publishVersion = "0.0.1"
    override def scalaVersion = versions.scala
}

object api2 extends ScalaModule with LibModule {
    override def artifactName = "api2"
    override def publishVersion = "0.0.1"
    override def scalaVersion = versions.scala
    override def moduleDeps = Seq(api1)
}

