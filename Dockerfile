# Etapa 1: Compilación
FROM maven:3.6.0-jdk-8 AS build
WORKDIR /Trivia-Deploy

# Copiar el contenido del proyecto al contenedor
COPY . .

# Ejecutar el empaquetado del proyecto con Maven
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución
FROM openjdk:8-jdk-alpine
WORKDIR /Trivia-Deploy

# Copiar el archivo JAR generado desde la etapa de compilación
COPY --from=build /Trivia-Deploy/target/docker-spring-boot.jar docker-spring-boot.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "docker-spring-boot.jar"]

# Exponer el puerto en el que tu aplicación escucha
EXPOSE 8080
