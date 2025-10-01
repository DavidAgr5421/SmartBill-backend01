# Dockerfile
# Etapa 1: Build (Compilación) CLAVE
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build

# Establecer directorio de trabajo MEH
WORKDIR /app

# Copiar archivos de configuración de Maven
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Descargar dependencias (se cachea si pom.xml no cambia)
RUN mvn dependency:go-offline -B

# Copiar código fuente
COPY src ./src

# Compilar la aplicación (sin ejecutar tests)
RUN mvn clean package -DskipTests

# Etapa 2: Runtime (Ejecución)
FROM eclipse-temurin:21-jre-alpine

# Crear usuario no-root para mayor seguridad
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copiar JAR desde la etapa de build GOD
COPY --from=build /app/target/*.jar app.jar

# Exponer puerto (ajusta según tu aplicación) BUENO
EXPOSE 8080

# Variables de entorno por defecto MEH
ENV JAVA_OPTS="-Xmx512m -Xms256m"

# Health check
HEALTHCHECK --interval=30s --timeout=3s --start-period=40s --retries=3 \
  CMD curl -f http://localhost:8080/actuator/health || exit 1

# Comando de inicio NORMAL
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]

