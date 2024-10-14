FROM openjdk:17
LABEL authors="Anastas"
COPY target/attestation3_1-0.0.1-SNAPSHOT.war app.war
ENTRYPOINT ["java", "-war", "app.war"]
EXPOSE 8080