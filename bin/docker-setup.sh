#!/usr/bin/env bash
set -eux
curl -fLo /usr/local/bin/coursier https://github.com/coursier/coursier/releases/download/v2.1.0-RC5/coursier
chmod +x /usr/local/bin/coursier
coursier setup --yes

curl -fLo maven.zip https://archive.apache.org/dist/maven/maven-3/3.9.1/binaries/apache-maven-3.9.1-bin.zip 
unzip -d /opt/maven maven.zip
rm maven.zip
mv /opt/maven/*/* /opt/maven

curl -fLo gradle.zip https://services.gradle.org/distributions/gradle-7.6.1-bin.zip
unzip -d /opt/gradle gradle.zip 
rm gradle.zip
mv /opt/gradle/*/* /opt/gradle

# pre-install JDK for all major versions
for JVM_VERSION in 17 11 8
do 
  coursier java --jvm $JVM_VERSION --jvm-index https://github.com/coursier/jvm-index/blob/master/index.json -- -version
done
