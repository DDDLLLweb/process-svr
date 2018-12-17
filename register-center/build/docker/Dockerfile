FROM openjdk:8-jre-alpine
ADD register-center-latest.jar app.jar
ADD logback-spring.xml /logback-spring.xml
CMD ["java","-jar","-Dspring.profiles.active=dev","-Dlogging.config=/logback-spring.xml","/app.jar"]
