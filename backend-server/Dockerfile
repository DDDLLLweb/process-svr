FROM frolvlad/alpine-oraclejdk8:slim
MAINTAINER Danfeng
ADD backend-server-latest.jar backend-server.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/backend-server.jar"]
