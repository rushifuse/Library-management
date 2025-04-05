# Use lightweight OpenJDK 17 image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy Maven wrapper and .mvn directory
COPY mvnw .
COPY .mvn .mvn

# Copy the Maven build file
COPY pom.xml .

# Download dependencies (for better Docker layer caching)
RUN chmod +x mvnw && ./mvnw dependency:go-offline

# Copy the source code
COPY src src

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose the port the app runs on
EXPOSE 8080

# Run the Spring Boot app
CMD ["java", "-jar", "target/Library-0.0.1-SNAPSHOT.jar"]
