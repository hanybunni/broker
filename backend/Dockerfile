FROM openjdk:17-jdk-slim as builder

WORKDIR /app

COPY . ./

RUN sed -i 's/\r$//' mvnw
RUN chmod +x ./mvnw
RUN ./mvnw package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
