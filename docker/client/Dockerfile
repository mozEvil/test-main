FROM openjdk:8-jdk-alpine
EXPOSE 8701
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]