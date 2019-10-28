FROM 902703094694.dkr.ecr.us-east-1.amazonaws.com/cwn-java
# FROM maven:3.5.4-jdk-8-slim

EXPOSE 8080

WORKDIR /usr/src/s3-io-tryer
ADD target/io.tryer-0.0.1-SNAPSHOT.jar io.tryer-0.0.1-SNAPSHOT.jar

CMD java ${JAVA_OPTIONS} -jar io.tryer-0.0.1-SNAPSHOT.jar
