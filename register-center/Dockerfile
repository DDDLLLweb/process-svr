FROM openjdk:8-jre-alpine
COPY register-center-latest.jar app.jar
CMD ["java","-jar","-Dspring.profiles.active=dev","/app.jar"]

