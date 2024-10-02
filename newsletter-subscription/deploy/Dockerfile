# ---- Stage 1: Build the application ----
FROM openjdk:21-slim AS builder

WORKDIR /usr/local/temp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

# ---- Stage 2: Create the final lightweight image ----
FROM openjdk:21-slim

ARG VERSION=7.2.0
LABEL version=${VERSION}
LABEL maintainer="Sacha Dubois"
LABEL description="Sample spring boot application for k8s environment"

WORKDIR /usr/local/app

RUN useradd --user-group --system --create-home --no-log-init app
USER app

COPY --from=builder /usr/local/temp/dependencies/ ./
COPY --from=builder /usr/local/temp/spring-boot-loader/ ./
COPY --from=builder /usr/local/temp/snapshot-dependencies/ ./
COPY --from=builder /usr/local/temp/application/ ./

# Set environment variables for Spring profile and datasource
ENV SPRING_PROFILES_ACTIVE=production

# Expose the default Spring Boot application port
EXPOSE 8080

# Use JarLauncher and pass the datasource credentials via environment variables
ENTRYPOINT ["java", "-Dspring.datasource.username=${SPRING_DATASOURCE_USERNAME}", "-Dspring.datasource.password=${SPRING_DATASOURCE_PASSWORD}", "org.springframework.boot.loader.launch.JarLauncher"]
