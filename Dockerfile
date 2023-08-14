# Build stage
FROM openjdk:11-jdk-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy only the POM file to leverage Docker caching
COPY pom.xml .

# Run Maven wrapper to build the project (with necessary profiles)
RUN chmod +x mvnw
RUN ./mvnw clean package -Pprod -DskipTests

# Package stage
FROM openjdk:11-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/amo_docker.jar amo_docker.jar

# Expose the port your Spring Boot application is listening on
EXPOSE 8080

# Run your application
ENTRYPOINT ["java", "-jar", "amo_docker.jar"]
