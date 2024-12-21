# Stage 1: Native Compilation with GraalVM
FROM quay.io/quarkus/ubi-quarkus-mandrel-builder-image:jdk-21 AS build

# Set the working directory
WORKDIR /workspace/app

# Copy files and set permissions for the Gradle wrapper
COPY . /workspace/app/
COPY --chmod=755 gradlew /workspace/app/gradlew

# Switch to root user for installing dependencies
USER root

# Install dependencies required for native builds
RUN microdnf install -y gcc glibc-devel zlib-devel \
    && microdnf clean all

# Set Gradle environment variables to fix file system watching issues
ENV GRADLE_OPTS="-Dorg.gradle.vfs.watch=false"

# Grant executable permissions to the Gradle wrapper (just in case COPY doesn't work)
RUN chmod +x ./gradlew

# Clean previous builds and stop Gradle daemons
RUN ./gradlew --stop
RUN ./gradlew clean

# Build the native executable with refreshed dependencies
RUN ./gradlew build \
    -Dquarkus.native.enabled=true \
    -Dquarkus.native.container-build=true \
    --refresh-dependencies \
    --stacktrace --info --no-daemon

# Stage 2: Minimal image for production
FROM quay.io/quarkus/quarkus-micro-image:2.0

# Copy the native binary from the build stage
COPY --from=build /workspace/app/build/native-image/*-runner /app

# Set executable permissions for the binary
RUN chmod +x /app

# Expose the application port
ENV PORT=10000
EXPOSE 10000

# Run the application
CMD ["/app"]
