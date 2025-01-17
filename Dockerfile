FROM maven:3.6.0-jdk-8 as build
ADD ./docker-spring-boot.jar docker-spring-boot.jar
ENTRYPOINT ["java", "-jar", "docker-spring-boot.jar"]
EXPOSE 8080
