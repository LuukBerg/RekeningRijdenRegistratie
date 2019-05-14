FROM openjdk:8-jdk-slim

ADD ./target /

CMD ["java", "jar", "rekeningrijdersregistratie-0.1.jar"]
