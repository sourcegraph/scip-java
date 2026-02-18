FROM eclipse-temurin:17@sha256:b624cb9175b71aaeb654dd9def666035332d5abf70318537c1a46e61564dbecd

RUN apt-get update && apt-get install --yes jq wget curl zip unzip git python3 python3-pip autoconf automake libtool build-essential libtool make g++

WORKDIR /workdir

COPY ./bin/docker-setup.sh .
RUN ./docker-setup.sh


ENV PATH=/opt/maven/bin:${PATH}
ENV PATH=/opt/gradle/bin:${PATH}
ENV PATH=/root/.local/share/coursier/bin:${PATH}

ENV JAVA_TOOL_OPTIONS="-XX:MaxRAMPercentage=80.0 -XX:+UseContainerSupport"
RUN git config --global --add safe.directory *

COPY . .

RUN sbt publishLocal dumpScipJavaVersion
RUN mkdir -p /app && coursier bootstrap "com.sourcegraph:scip-java_2.13:$(cat VERSION)" -f -o /app/scip-java -M com.sourcegraph.scip_java.ScipJava

COPY ./bin/scip-java-docker-script.sh /usr/bin/scip-java

WORKDIR /sources

RUN rm -rf /workdir
