FROM java:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY $JAR_FILE app.jar
RUN ["java", "-jar", "app.jar"]