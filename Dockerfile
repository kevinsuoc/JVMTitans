FROM openjdk:23
WORKDIR /usr/src/JVMTITANS
COPY JVMTITANS/build/libs/JVMTITANS-practica4-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]