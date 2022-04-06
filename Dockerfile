FROM openjdk:11
WORKDIR /app
COPY target/upload-service-0.0.1-SNAPSHOT.war .
ENTRYPOINT ["java","-jar","/app/upload-service-0.0.1-SNAPSHOT.war"]