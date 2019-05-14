FROM openjdk:8-jdk-slim

ADD ./target/rekeningrijdersregistratie-0.1.jar rekeningrijdersregistratie-0.1.jar

CMD ["java", "-jar", "rekeningrijdersregistratie-0.1.jar"]
