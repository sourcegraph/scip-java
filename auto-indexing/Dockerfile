FROM gradle:7.0.0-jdk8@sha256:cef49a7bdb0c53dc0d64ed24f375fb0fdd6e3489d0b4fcd393f0c8c09be11320
RUN apt-get update
RUN apt-get install --yes maven npm
RUN curl -fLo /coursier https://git.io/coursier-cli
RUN chmod +x /coursier
RUN npm install --global yarn
RUN /coursier launch --contrib --ttl 0 lsif-java -- --help
