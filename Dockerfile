FROM openjdk:11-jre-slim-buster
COPY  ./build/libs/profile-1.0.0.jar /app.jar
EXPOSE 8080
RUN groupadd -r user && useradd -r -g user user
USER user
ENTRYPOINT ["java", "-jar", "/app.jar"]
