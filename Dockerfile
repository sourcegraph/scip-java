FROM sourcegraph/lsif-java
COPY bin/packagehub.sh /packagehub.sh
RUN chmod +x /packagehub.sh
RUN git config --global user.email "you@example.com"
RUN git config --global user.name "Your Name"
RUN git config --global http.postBuffer 1048576000
RUN curl -L https://sourcegraph.com/.api/src-cli/src_linux_amd64 -o /src
RUN chmod +x /src
RUN /coursier bootstrap -r sonatype:snapshots com.sourcegraph:packagehub_2.13:0.5.1-26-2d4609cc-SNAPSHOT -o /packagehub
ENV COURSIER_REPOSITORIES=central|https://maven.google.com/|jitpack
CMD ["/packagehub.sh"]
