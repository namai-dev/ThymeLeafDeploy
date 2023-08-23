FROM eclipse-temurin:19-jdk-alpine
VOLUME /tmp
COPY --from=buld /target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
