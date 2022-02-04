FROM openjdk:8-jdk as build
RUN rm /etc/localtime
RUN ln -s /usr/share/zoneinfo/Australia/Melbourne /etc/localtime
COPY target/account-0.0.1-SNAPSHOT.jar run.jar
ENTRYPOINT ["java","-jar","run.jar"]