FROM openjdk:8-jdk-slim

ADD ./target /

CMD ["java", "jar", "1rekeningrijdersregistratie-0.1.jar"]
