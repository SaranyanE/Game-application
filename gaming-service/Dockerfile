FROM ubuntu:latest

FROM openjdk

LABEL authors="Saranyan.E"

COPY target/*.jar /gaming-service.jar

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "/gaming-service.jar"]