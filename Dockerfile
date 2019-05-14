FROM openjdk:8-jdk-slim

COPY ./target/rekeningrijdersregistratie-0.1.jar /usr/src/test/

WORKDIR /usr/src/test

CMD ["java", "jar", "rekeningrijdersregistratie-0.1.jar"]
