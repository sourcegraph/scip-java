# Java LSIF indexer

Visit https://lsif.dev/ to learn about LSIF.

## Installation

- Java 1.8 or higher
- [Maven](https://maven.apache.org/install.html) (macOS: `brew install maven`)

**macOS**

```
brew cask install java
brew install maven
```

**Ubuntu 18.04**

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

**Step 1** Ensure you have a `pom.xml` (Maven projects already have one):

For Gradle projects:

1. Add [`maven-publish`](https://docs.gradle.org/current/userguide/publishing_maven.html) to your `plugins` in `build.gradle`
2. Specify a publication (TODO specify the destination):

```groovy
publishing {
  publications {
    mavenJava(MavenPublication) {
      from components.java
    }
  }
}
```

3. Run `./gradlew generatePomFileForPubNamePublication`
4. You should now see `pom.xml` at the top of your project directory

**Step 2** Generate an LSIF dump:

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
