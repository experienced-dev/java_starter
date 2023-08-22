FROM openjdk:17-jdk-slim

# Set environment variables
ENV JVM_MAX_MEMORY = "1024m"

COPY build/libs/*.jar /app.jar

# Set JVM memory restriction to 1GB
ENTRYPOINT ["java", "-Xmx${JVM_MAX_MEMORY}", "-jar", "/app.jar"]
