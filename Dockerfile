FROM openjdk:8-jdk-slim

COPY ./target/rekeningrijdersregistratie-0.1.jar /home/rekeningrijdersregistratie-0.1.jar

CMD ["java", "jar", "/home/grekeningrijdersregistratie-0.1.jar"]
