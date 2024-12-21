# Stage 1: Native Compilation with GraalVM
FROM quay.io/quarkus/ubi-quarkus-mandrel-builder-image:jdk-21 AS build

# Set the work directory
WORKDIR /workspace/app

# Copy files and set permissions
COPY . /workspace/app/
COPY --chmod=755 gradlew /workspace/app/gradlew
USER root

# Install dependencies required for native build
RUN microdnf install -y gcc glibc-devel zlib-devel \
    && microdnf clean all

# Grant execution permissions to Gradle wrapper
RUN chmod +x ./gradlew

# Environment variable to fix Gradle file system watching issue
ENV GRADLE_OPTS="-Dorg.gradle.vfs.watch=false"

# Clean any previous builds
RUN ./gradlew --stop
RUN ./gradlew clean

# Build native executable
RUN ./gradlew build -Dquarkus.native.enabled=true -Dquarkus.native.container-build=true --stacktrace --info --no-daemon

# Stage 2: Image minimum for production
FROM quay.io/quarkus/quarkus-micro-image:2.0

# Copy native file
COPY --from=build /workspace/app/build/native-image/*-runner /app

# Set executable permissions
RUN chmod +x /app

# Expose port
ENV PORT=10000
EXPOSE 10000

# Init command
CMD ["/app"]