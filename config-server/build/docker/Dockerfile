FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD config-server-1.0.0.jar config-server.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/config-server.jar"]
