FROM gradle:7.0.0-jdk8
RUN apt-get update && \
      apt-get install --yes maven && \
      curl -fLo /coursier https://git.io/coursier-cli && \
      chmod +x /coursier && \
      /coursier launch --contrib lsif-java -- --help
