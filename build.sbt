import AssemblyKeys._ 

assemblySettings

name := "executable-app"

version := "1.0-SNAPSHOT"

play.Project.playScalaSettings

mainClass in assembly := Some("CLI")

mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
  {
    case PathList("org", "apache", "commons", "logging", xs @ _*)         => MergeStrategy.first
    case PathList(ps @ _*) if ps.last endsWith "MANIFEST.MF"              => MergeStrategy.discard
    case PathList(ps @ _*) if ps.last endsWith "ServerWithStop.class"     => MergeStrategy.first
    case PathList(ps @ _*) if ps.last endsWith "reference.conf"           => MergeStrategy.first
    case _ => MergeStrategy.deduplicate
  }
}
