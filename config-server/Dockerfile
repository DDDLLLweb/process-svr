FROM openjdk:8-jre-alpine
MAINTAINER Danfeng
ADD config-server-latest.jar config-server.jar
CMD ["java","-jar","-Dspring.profiles.active=prod","/config-server.jar"]
