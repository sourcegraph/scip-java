FROM openjdk:8-jdk-alpine
COPY bin/coursier coursier
RUN apk add --no-cache git curl \
    && git config --global user.email "you@example.com" \
    && git config --global user.name "Your Name" \
    && git config --global http.postBuffer 1048576000 \
    && curl -L https://sourcegraph.com/.api/src-cli/src_linux_amd64 -o /src \
    && chmod +x /src \
    && /coursier bootstrap -r sonatype:snapshots com.sourcegraph:packagehub_2.13:0.5.0-12-69905fcb-SNAPSHOT -o /packagehub
ENV COURSIER_REPOSITORIES=central|https://maven.google.com/|jitpack
ENTRYPOINT /packagehub --host 0.0.0.0 --port $PORT --src /src --coursier /coursier --postgres.username=$DB_USER --postgres.password=$DB_PASS --postgres.url=$DB_URL --auto-index-delay=PT1M
