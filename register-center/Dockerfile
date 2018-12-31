FROM openjdk:8-jre-alpine
MAINTAINER Danfeng
RUN apk update \
      && apk upgrade \
      && apk add --no-cache bridge-utils \
      && rm -rf /var/cache/apk/*
COPY register-center-latest.jar register-center.jar
CMD ["java","-jar","-Dspring.profiles.active=prod","/register-center.jar"]
