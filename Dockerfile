FROM maven:3.6.0-jdk-8 as build
WORKDIR /Trivia-Deploy
COPY target/docker-spring-boot.jar /Trivia-Deploy/docker-spring-boot.jar
# Define el puerto en el que tu aplicación escucha
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/Trivia-Deploy/docker-spring-boot.jar"]
