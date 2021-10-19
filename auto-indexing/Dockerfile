FROM gradle:7.2.0-jdk8@sha256:b35400ea7916acb1966e388dfc9bc87a0b0190bfe5a9c361c3b5c9a9d1bc5f4a
RUN apt-get update
RUN apt-get install --yes maven npm
RUN curl -fLo /coursier https://git.io/coursier-cli
RUN chmod +x /coursier
RUN npm install --global yarn
RUN /coursier bootstrap --standalone com.sourcegraph:lsif-java_2.13:0.6.11 -o /usr/local/bin/lsif-java
