# Use a base image with Maven to build the application
FROM maven:3.9.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn clean package -DskipTests
COPY src ./src
RUN mvn package -DskipTests

# Use a smaller base image to run the application
FROM adoptopenjdk:17-jre-hotspot
WORKDIR /app
COPY --from=build /app/target/amo_docker.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]