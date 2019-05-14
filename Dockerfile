FROM openjdk:8-jdk-slim

WORKDIR /

ADD ./target/rekeningrijdersregistratie-0.1.jar rekeningrijdersregistratie-0.1.jar

CMD ["java", "jar", "/home/grekeningrijdersregistratie-0.1.jar"]
