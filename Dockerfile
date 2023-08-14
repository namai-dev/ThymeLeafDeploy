FROM openjdk:17

EXPOSE 8080
ADD target/amo_docker.jar amo_docker.jar

ENTRYPOINT ["java", "-jar", "/amo_docker.jar"]

