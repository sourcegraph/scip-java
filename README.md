# Java LSIF indexer ![](https://img.shields.io/badge/status-development-yellow?style=flat)

Visit https://lsif.dev/ to learn about LSIF.

## Installation

- Java 1.8 or higher
- Maven

### macOS ###

We recommend using brew to install dependancies on mac OS, you can install brew using the following command:
```
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install.sh)"
```

If you already have brew installed, you'll need to make sure its up to date: 
```
brew update && brew upgrade brew-cask && brew cleanup && brew cask cleanup
```

Install Java:
```
brew tap homebrew/cask-versions
brew update
brew cask install homebrew/cask-versions/adoptopenjdk8
```

Install Maven:
```
brew install maven
```

### Ubuntu 18.04 ###

```
apt-get update && apt-get install -y git default-jdk maven
```

## Build the LSIF indexer

```
git clone https://github.com/sourcegraph/lsif-java
cd lsif-java
./gradlew installDist
```

## Generating an LSIF dump

### **Step 1**

Ensure you have a `pom.xml` (Maven projects already have one):

For single-project Gradle projects **_(experimental)_**:

1. Add [`maven-publish`](https://docs.gradle.org/current/userguide/publishing_maven.html) to your `plugins` in `build.gradle`
```
plugins {
  id 'maven-publish'
}
```
2. Specify a publication:

**_with default sourceSets:_**

```groovy
publishing {
    model {
        tasks.generatePomFileForSourcegraphPublication {
            destination = file("$projectDir/pom.xml")
        }
    }
    publications {
        sourcegraph(MavenPublication) {
            from components.java
        }
    }
}
```

**_with non-default sourceSets:_**

```groovy
publishing {
    model {
        tasks.generatePomFileForSourcegraphPublication {
            destination = file("$projectDir/pom.xml")
        }
    }
    publications {
        sourcegraph(MavenPublication) {
            from components.java
            def sourceSets = project.sourceSets.main.java.srcDirs
            pom.withXml {
                def node = asNode();
                if (node.get("build").size() == 0) {
                    node.appendNode("build").with {
                        if (sourceSets.size() > 0) {
                            appendNode("sourceDirectory", sourceSets.first())
                        }
                    }
                }
            }
        }
    }
}
```

3. Run `./gradlew generatePomFileForSourcegraphPublication`
4. You should now see `pom.xml` at the top of your project directory

For multi-project Gradle projects **_(experimental)_**:

1. Modify your `allprojects` block in the root `build.gradle` to include the following:

```groovy
allprojects {
    // ...

    apply plugin: "maven-publish"

    afterEvaluate { project ->
        if (!new File(project.projectDir.toString()+"/build.gradle").exists()) return
        publishing {
            model {
                tasks.generatePomFileForSourcegraphPublication {
                    destination = file("$projectDir/pom.xml")
                }
            }
            publications {
                sourcegraph(MavenPublication) {
                    def projectDirStr = project.projectDir
                    def subprojectSet = project.subprojects
                    def projectPath = project.path.replace(":", "/")/* .substring(1) */
                    if (projectPath.startsWith("/")) {
                        projectPath = projectPath.substring(1)
                    }
                    def sourceSetsSet = []
                    if (project.hasProperty("sourceSets.main.java.srcDirs")) {
                        sourceSetsSet = project.sourceSets.main.java.srcDirs
                    }

                    if (!(new File(projectDirStr.toString()+"/build.gradle").exists())) return

                    def javaApplied = components.collect{it.getName()}.contains("java")
                    if (javaApplied) from components.java

                    pom.withXml {
                        def node = asNode();
                        if (node.get("build").size() == 0 && javaApplied) {
                            node.appendNode("build").with {
                                if (sourceSetsSet.size() > 0) {
                                    appendNode("sourceDirectory", sourceSetsSet.first())
                                } else {
                                    def dirpath = "${projectDirStr}/src/main/java"
                                    if (new File(dirpath).exists()) appendNode("sourceDirectory", dirpath)
                                }
                            }
                        }

                        if (subprojectSet.size() > 0) {
                            node.appendNode("modules").with {
                                for(Project p : subprojectSet) {
                                    if(new File(p.path.replace(":", "/./").substring(1)+"/build.gradle").exists()) {
                                        def path = p.path.replace(":", "/").substring(1)
                                        if (path.startsWith(projectPath) && projectPath != "") {
                                            path = path.substring(projectPath.length()+1)
                                        }
                                        appendNode("module", path)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
```

2. Run `./gradlew generatePomFileForSourcegraphPublication`
3. You should now see a `pom.xml` file for each `build.gradle` throughout the project

### **Step 2**
Generate an LSIF dump:

```
<absolute path to lsif-java>/build/install/lsifjava/bin/lsifjava \
  -projectRoot <project directory> \
  -out dump.lsif
```

## Comparison to [Microsoft/lsif-java](https://github.com/Microsoft/lsif-java)

- sourcegraph/lsif-java is ~10x faster
- sourcegraph/lsif-java supports cross-file hovers/definitions/references (Microsoft/lsif-java does not)
- sourcegraph/lsif-java uses [Spoon](https://github.com/INRIA/spoon), which is built on [eclipse.jdt.core](https://github.com/eclipse/eclipse.jdt.core)
- Microsoft/lsif-java uses [eclipse.jdt.ls](https://github.com/eclipse/eclipse.jdt.ls), which is also built on [eclipse.jdt.core](https://github.com/eclipse/eclipse.jdt.core)

See https://github.com/microsoft/lsif-java/issues/61 for the status of collaboration efforts.

## Development

```
./dev
```
