FROM maven:3.6.0-jdk-8 as build
ENV JAVA_TOOL_OPTIONS "-Djdk.net.URLClassPath.disableClassPathURLCheck=true"
ADD ./docker-spring-boot.jar docker-spring-boot.jar
ENTRYPOINT ["java", "-jar", "docker-spring-boot.jar"]