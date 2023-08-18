# Etapa de construcción
FROM maven:3.8.3-openjdk-17 as build
WORKDIR /app
COPY . .
RUN mvn clean package

# Etapa final para la imagen en producción
FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]



