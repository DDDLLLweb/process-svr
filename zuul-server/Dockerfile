FROM openjdk:8-jre-alpine
VOLUME /tmp
ADD zuul-server-latest.jar zuul-server.jar
ENTRYPOINT ["java","-jar","/zuul-server.jar"]
