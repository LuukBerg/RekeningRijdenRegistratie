FROM openjdk:10-jre-slim

COPY ./target/rekeningrijdersregistratie-0.1.jar /usr/src/reg/regdeployment/

WORKDIR /usr/src/reg

CMD ["java", "jar", "rekeningrijdersregistratie-0.1.jar"]
