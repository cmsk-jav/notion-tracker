#
# Build stage
#
FROM maven:3.9.2-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM eclipse-temurin:17-jdk-alpine
COPY --from=build /target/Notion-Client-0.0.1-SNAPSHOT.jar notion-client.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","notion-client.jar"]
