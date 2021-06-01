FROM gradle:7.0.2-jdk8@sha256:b36aabaa3f4b333aae071be8658ad2fa558bcaea9e31b3e8dc42f6e7846cbd01
RUN apt-get update
RUN apt-get install --yes maven npm
RUN curl -fLo /coursier https://git.io/coursier-cli
RUN chmod +x /coursier
RUN npm install --global yarn
RUN /coursier launch --contrib --ttl 0 lsif-java -- --help
