FROM 902703094694.dkr.ecr.us-east-1.amazonaws.com/cwn-java
# FROM maven:3.5.4-jdk-8-slim

EXPOSE 9000 9001

WORKDIR /usr/src/boot-docker-tryer
ADD target/docker.tryer-0.0.1-SNAPSHOT.jar docker.tryer-0.0.1-SNAPSHOT.jar

CMD java ${JAVA_OPTIONS} -jar docker.tryer-0.0.1-SNAPSHOT.jar
