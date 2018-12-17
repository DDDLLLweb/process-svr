FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD zuul-server-latest.jar zuul-server.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/zuul-server.jar"]
