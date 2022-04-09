FROM adoptopenjdk:11-jre-hotspot
EXPOSE 8700
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]