FROM openjdk:8-jdk-slim

ADD ./target /

CMD ["java", "jar", "/grekeningrijdersregistratie-0.1.jar"]
