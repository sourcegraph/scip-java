FROM gradle:7.2.0-jdk8@sha256:fa25782f22f6d7937e3c9442e791991604ed0c007c3638ae0623d8a9c8f05452
RUN apt-get update
RUN apt-get install --yes maven npm
RUN curl -fLo /coursier https://git.io/coursier-cli
RUN chmod +x /coursier
RUN npm install --global yarn
RUN /coursier bootstrap --standalone com.sourcegraph:lsif-java_2.13:0.6.11 -o /usr/local/bin/lsif-java
