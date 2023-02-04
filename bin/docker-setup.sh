#!/usr/bin/env bash
set -eux
curl -fL https://github.com/coursier/coursier/releases/download/v2.1.0-RC5/cs-x86_64-pc-linux-static.gz | gzip -d > cs
chmod +x cs
./cs setup --yes --jvm 17 --architecture amd64

curl -fLo gradle.zip https://services.gradle.org/distributions/gradle-7.6-bin.zip
unzip -d /opt/gradle gradle.zip

curl -fLo maven.zip https://dlcdn.apache.org/maven/maven-3/3.8.7/binaries/apache-maven-3.8.7-bin.zip
unzip -d /opt/maven maven.zip

rm gradle.zip maven.zip cs