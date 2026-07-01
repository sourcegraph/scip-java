import com.vanniktech.maven.publish.MavenPublishBaseExtension

plugins {
    id("com.vanniktech.maven.publish")
}

extensions.configure<MavenPublishBaseExtension>("mavenPublishing") {
    val repositoryUrl = "https://github.com/scip-code/scip-java"
    publishToMavenCentral()
    signAllPublications()

    pom {
        name.set(project.name)
        description.set(provider { project.description ?: project.name })
        url.set(repositoryUrl)
        licenses {
            license {
                name.set("Apache-2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0")
            }
        }
        developers {
            developer {
                id.set("scip-code")
                name.set("SCIP Code")
            }
        }
        scm {
            connection.set("scm:git:$repositoryUrl.git")
            developerConnection.set("scm:git:ssh://git@github.com/scip-code/scip-java.git")
            url.set(repositoryUrl)
        }
    }
}
