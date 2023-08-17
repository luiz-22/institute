# Utiliza una imagen base de OpenJDK para Java 17
FROM openjdk:17-alpine

# Define el directorio de trabajo en el contenedor
WORKDIR /app

COPY .env /app/application-dev.properties

# Copia el archivo JAR de tu aplicación al contenedor
COPY target/institute-0.0.1-SNAPSHOT.jar /app/app.jar

# Exponer el puerto en el que escucha tu aplicación Spring Boot (ajusta si es diferente)
EXPOSE 8080

# Comando para ejecutar la aplicación cuando el contenedor se inicie
CMD ["java", "-jar", "app.jar"]