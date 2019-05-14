FROM openjdk:8-jdk-slim

COPY ./target/rekeningrijdersregistratie-0.1.jar /usr/src/reg/

WORKDIR /usr/src/reg

CMD ["java", "jar", "rekeningrijdersregistratie-0.1.jar"]
