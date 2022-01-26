FROM openjdk:8-jdk as build
COPY target/discovery-0.0.1-SNAPSHOT.jar run.jar
ENTRYPOINT ["java","-jar","run.jar"]