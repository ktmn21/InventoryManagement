# Use an official OpenJDK 17 runtime as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from the target directory to the container
COPY target/Inventory-management-0.0.1-SNAPSHOT.jar /app/Inventory-management.jar

# Expose the application's port
EXPOSE 8080

# Set environment variables for MySQL (you can customize these as needed)
# Use host.docker.internal to access the host's MySQL server
ENV SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3306/inventory \
    SPRING_DATASOURCE_USERNAME=i_manager \
    SPRING_DATASOURCE_PASSWORD=12345

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/Inventory-management.jar"]
