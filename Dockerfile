FROM ubuntu:22.04

RUN apt-get update && apt-get install -y curl zip unzip && \
    curl -s https://get.sdkman.io | bash && \
    bash -c 'source /root/.sdkman/bin/sdkman-init.sh && \
             sdk install java 25-open'

EXPOSE 8081

COPY target/master2-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT ["bash", "-c", \
  "source /root/.sdkman/bin/sdkman-init.sh && \
   java -jar /app.jar"]