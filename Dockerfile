# Use OpenJDK 17 slim image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy Maven wrapper and related files (for cache optimization)
COPY mvnw .
COPY .mvn .mvn

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN chmod +x mvnw && ./mvnw dependency:go-offline

# Copy the full source code
COPY src src

# Build the Spring Boot app
RUN ./mvnw clean package -DskipTests

# Expose the port your app runs on (match application.properties)
EXPOSE 8080

# Run the app
CMD ["java", "-jar", "target/Library-0.0.1-SNAPSHOT.jar"]
