#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:11-jdk-slim
COPY --from=build /target/amo_docker.jar amo_docker.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","amo_docker.jar"]
