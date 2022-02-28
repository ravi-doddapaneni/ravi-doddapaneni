FROM openjdk:11-jdk-slim-buster as build
RUN mkdir -p /source
WORKDIR source

COPY src ./src
COPY build.gradle .
COPY gradlew .
COPY gradle ./gradle
COPY gradle.properties .
RUN chmod +x ./gradlew && ./gradlew build

FROM openjdk:11-jre-slim-buster
COPY --from=build /source/build/libs/*.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]