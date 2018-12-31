FROM openjdk:8-jre-alpine
MAINTAINER Danfeng
ADD zuul-server-latest.jar zuul-server.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/zuul-server.jar"]
