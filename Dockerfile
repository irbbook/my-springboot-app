# Use a slim OpenJDK image as the base
FROM openjdk:24-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot JAR file into the container
# Assuming your Spring Boot build generates a JAR named 'my-springboot-app-0.0.1-SNAPSHOT.jar'
# Adjust the JAR name to match your actual build output
ARG JAR_FILE=target/my-springboot-app-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Expose the port your Spring Boot application listens on (default is 8080, but can be 80 in prod)
# We will control the actual port mapping in Kubernetes Service
EXPOSE 8080

# Command to run the Spring Boot application
# SPRING_PROFILES_ACTIVE will be passed via Kubernetes Deployment environment variables
ENTRYPOINT ["java", "-jar", "app.jar"]