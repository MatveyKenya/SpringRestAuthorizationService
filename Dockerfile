FROM openjdk:17-alpine3.14

EXPOSE 8080

COPY target/SpringRestAuthorizationService-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "/app.jar"]