FROM openjdk:17

# Create a directory within the container
WORKDIR /app

# Copy the JAR file into the container's directory
COPY target/amo_docker.jar amo_docker.jar

# Expose the port your Spring Boot application is listening on
EXPOSE 8080

# Run your application
CMD ["java", "-jar", "amo_docker.jar"]
