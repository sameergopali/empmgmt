# Use a multi-stage build to create a smaller final image

# Stage 1: Build
FROM gradle:8.2.1-jdk17-alpine AS build
WORKDIR /app
COPY build.gradle .
COPY src ./src
COPY gradlew .
COPY settings.gradle .
RUN gradle build -x test

# Stage 2: Run
FROM openjdk:17.0.2-slim
WORKDIR /app
COPY --from=build /app/build/libs/*.jar /app/
RUN ls
ENTRYPOINT ["java", "-jar", "/app/employeemanagement-0.0.1-SNAPSHOT.jar"]

# Expose port 8080
EXPOSE 8080
