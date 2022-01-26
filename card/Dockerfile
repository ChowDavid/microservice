FROM openjdk:8-jdk as build
COPY target/card-0.0.1-SNAPSHOT.jar run.jar
ENTRYPOINT ["java","-jar","run.jar"]