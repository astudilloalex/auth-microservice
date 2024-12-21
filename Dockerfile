# Stage 1: Native Compilation with GraalVM
FROM quay.io/quarkus/ubi-quarkus-mandrel-builder-image:jdk-21 AS build

# Set the work directory
WORKDIR /workspace/app

# Copy files and set permissions
COPY . /workspace/app/
COPY --chmod=755 gradlew /workspace/app/gradlew
USER root

# Install dependencies required for native build
RUN yum install -y gcc glibc-devel zlib-devel \
    && yum clean all \
    && rm -rf /var/cache/yum

# Grant execution permissions to Gradle wrapper
RUN chmod +x ./gradlew

# Build native executable
RUN ./gradlew build -Dquarkus.native.enabled=true -Dquarkus.native.container-build=true --stacktrace --info

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
