#FROM hypriot/rpi-java
FROM openjdk
COPY target/meteo-1.0-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
