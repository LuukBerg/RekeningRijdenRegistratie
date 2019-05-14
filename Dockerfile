FROM openjdk:8-jdk-slim

COPY ./target/rekeningrijdersregistratie-0.1.jar /home/student/dockerCompose/regdeployment

WORKDIR /home/student/dockerCompose/regdeployment

CMD ["java", "jar", "rekeningrijdersregistratie-0.1.jar"]
