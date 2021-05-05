FROM gradle:7.0.0-jdk8@sha256:25ecb23e3516b697219f5a780bf68598318cf13b35ca616f4521c7e9e115a11e
RUN apt-get update && \
      apt-get install --yes maven && \
      curl -fLo /coursier https://git.io/coursier-cli && \
      chmod +x /coursier && \
      /coursier launch --contrib lsif-java -- --help
