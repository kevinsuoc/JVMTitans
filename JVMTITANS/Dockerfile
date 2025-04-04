# Usamos una imagen base de Java
FROM openjdk:23

# Establecemos el directorio de trabajo
WORKDIR /app

# Copiamos el archivo JAR del proyecto al contenedor
COPY build/libs/JVMTITANS-0.0.1-SNAPSHOT.jar app.jar

# Ejecutamos la aplicación
CMD ["java", "-jar", "app.jar"]