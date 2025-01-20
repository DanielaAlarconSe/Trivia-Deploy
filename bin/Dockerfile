# Optimized and Organized Dockerfile

# Stage 1: Build stage
FROM maven:3.6.3-jdk-8 AS build
WORKDIR /Trivia-Deploy

# Copy source code and Maven configuration
COPY src /Trivia-Deploy/src
COPY pom.xml /Trivia-Deploy

# Build the application and skip tests to speed up the process
RUN mvn clean package -DskipTests

# Stage 2: Execution stage
FROM openjdk:8-jre
WORKDIR /Trivia-Deploy

# Copy the built JAR file from the build stage
COPY --from=build /Trivia-Deploy/target/docker-spring-boot.jar docker-spring-boot.jar

# Expose the application port
EXPOSE 8080

# Define the entry point for the container
ENTRYPOINT ["java", "-Xms512m", "-Xmx1024m", "-jar", "docker-spring-boot.jar"]

