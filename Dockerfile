# Define a imagem base
FROM openjdk:17
WORKDIR /app
COPY target/STAG2-504_ClientApi-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "STAG2-504_ClientApi-0.0.1-SNAPSHOT.jar"]