# Stage 1: Native Compiation with GraalVM
FROM quay.io/quarkus/ubi-quarkus-mandrel-builder-image:jdk-21 AS build

# Set the work directory
WORKDIR /workspace/app

# Copy files
COPY . /workspace/app/
COPY --chmod=755 gradlew /workspace/app/gradlew
USER root

# Build native executable
RUN ./gradlew build -Dquarkus.native.enabled=true -Dquarkus.native.container-build=true

# Stage 2: Image minimum for production
FROM quay.io/quarkus/quarkus-micro-image:2.0

# Copy native file
COPY --from=build /workspace/app/target/*-runner /app

# Expose port
ENV PORT=10000
EXPOSE 10000

# Init command
CMD ["./app"]
