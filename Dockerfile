FROM gradle:8.12.0-jdk17 AS build
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle gradle gradle
COPY --chown=gradle:gradle gradlew build.gradle.kts settings.gradle.kts gradlew.bat ./
RUN ./gradlew dependencies --no-daemon
COPY --chown=gradle:gradle . ./
RUN ./gradlew build --no-daemon

FROM openjdk:21-jdk-slim
COPY --from=build /home/gradle/src/build/libs/*.jar /app.jar
ENV JAVA_OPTS="-Xmx1024m"
ENTRYPOINT ["java", "-jar", "/app.jar"]
