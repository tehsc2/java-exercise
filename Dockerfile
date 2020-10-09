FROM openjdk:8-jdk-alpine
MAINTAINER "Esther Cecim <tehsc2@gmail.com>"
WORKDIR /app

COPY ./target/*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

EXPOSE 8080
