# Use OpenJDK as base image
FROM openjdk:21-slim

# Set working directory inside container
WORKDIR /app

# Copy the built JAR file from host to container
COPY target/Security-0.0.1-SNAPSHOT.jar security.jar

# Expose port 8080
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "security.jar"]
