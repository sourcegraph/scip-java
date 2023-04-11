#!/usr/bin/env bash
set -eux
curl -fLo /usr/local/bin/coursier https://github.com/coursier/coursier/releases/download/v2.1.0-RC5/coursier
chmod +x /usr/local/bin/coursier
coursier setup --yes

curl -fLo maven.zip https://archive.apache.org/dist/maven/maven-3/3.9.1/binaries/apache-maven-3.9.1-bin.zip 
unzip -d /opt/maven maven.zip
mv /opt/maven/*/* /opt/maven

rm maven.zip
