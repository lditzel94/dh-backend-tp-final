FROM amazoncorretto:17.0.6-al2023-headless

WORKDIR /app
COPY target/backend-tp-final-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080
