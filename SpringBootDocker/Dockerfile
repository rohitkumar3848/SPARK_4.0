
#instruction to craete docker image


# 1. Java Runtime Environment (JRE) base image
FROM eclipse-temurin:21-jdk

#working dir inside container
WORKDIR /app

#copy jar file inside container
COPY target/SpringBootDocker-0.0.1-SNAPSHOT.jar app.jar

# expose the port
EXPOSE 8080

#command to run app.jar
ENTRYPOINT ["java", "-jar","app.jar"]
