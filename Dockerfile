# Etapa de construcción
FROM maven:3.6.3-jdk-8 AS build
WORKDIR /Trivia-Deploy
COPY . .
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM openjdk:8-jre
WORKDIR /Trivia-Deploy
COPY --from=build /Trivia-Deploy/target/docker-spring-boot.jar docker-spring-boot.jar.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "docker-spring-boot.jar.jar"]
