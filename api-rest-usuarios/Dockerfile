# Equivalente FROM mysql:8.0.18
# Nos descargamos el contenedor (docker) oficial
# Open JDK, sÃ³lo el proyecto JRE

FROM openjdk:8-jre-slim
# Definimos variable
ARG JAR_FILE=target/*.jar
# Copiando al interior del contenedor
# el directorio raíz
COPY ${JAR_FILE} /api-rest-usuarios.jar
CMD java -jar /api-rest-usuarios.jar