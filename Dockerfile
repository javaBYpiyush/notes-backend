# build stage
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn -B clean package -DskipTests

# runtime stage
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Let the container use the PORT env var that Render provides
EXPOSE 8080
ENTRYPOINT ["sh","-c","java -jar app.jar --server.port=${PORT:-8080}"]
