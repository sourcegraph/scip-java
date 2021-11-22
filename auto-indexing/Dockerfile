FROM gradle:7.2.0-jdk8@sha256:51a695072259173d04e0d6cb590d2590b1c58834c436b6b66e3a6269cdaf1aa4
RUN apt-get update
RUN apt-get install --yes maven npm
RUN curl -fLo /coursier https://git.io/coursier-cli
RUN chmod +x /coursier
RUN npm install --global yarn
RUN /coursier bootstrap --standalone com.sourcegraph:lsif-java_2.13:0.6.11 -o /usr/local/bin/lsif-java
