# Stage 1: Build JAR with Gradle
FROM eclipse-temurin:21-jdk AS build

# Set the working directory
WORKDIR /workspace/app

# Copy files and set permissions for the Gradle wrapper
COPY . /workspace/app/
COPY --chmod=755 gradlew /workspace/app/gradlew

# Install dependencies required for build
RUN apt-get update && apt-get install -y libstdc++6 zlib1g-dev && apt-get clean

# Build the JAR file
RUN ./gradlew build \
    --refresh-dependencies \
    --stacktrace --info --no-daemon

# Stage 2: Create lightweight image for production
FROM eclipse-temurin:21-jre

# Set the working directory
WORKDIR /app

# Copy JAR files from the build stage
COPY --from=build /workspace/app/build/quarkus-app/ /app/

# Expose the application port
ENV PORT=10000
EXPOSE 10000

# Run the application
CMD ["java", "-jar", "/app/quarkus-run.jar"]
