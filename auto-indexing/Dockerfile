FROM gradle:7.0.0-jdk8@sha256:25ecb23e3516b697219f5a780bf68598318cf13b35ca616f4521c7e9e115a11e
RUN apt-get update
RUN apt-get install --yes maven npm
RUN curl -fLo /coursier https://git.io/coursier-cli
RUN chmod +x /coursier
RUN npm install --global yarn
RUN /coursier launch --contrib --ttl 0 lsif-java -- --help
