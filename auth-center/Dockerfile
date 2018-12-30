FROM openjdk:8-jre-alpine
MAINTAINER Danfeng
ADD auth-center-latest.jar auth-center.jar
CMD ["java","-jar","-Dspring.profiles.active=prod","/auth-center.jar"]
