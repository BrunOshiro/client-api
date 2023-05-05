# Para dizer de onde estão vindo os dados
FROM openjdk

# Diretório raíz do container
WORKDIR /api/v1.0/clientEntities

RUN src/main/java/com/jazztech/STAG2504_ClientApi/Stag2504ClientApiApplication.java

# Onde o Docker vai copiar o arquivo para dentro do container
COPY target/classes/com/jazztech/STAG2504_ClientApi/Stag2504ClientApiApplication.java

# Comando a ser executado quando o container for iniciado
ENTRYPOINT ["java", "-jar", "STAG2-504_ClientApi.jar"]