FROM maven:3.5.4-jdk-8-slim

EXPOSE 9000
VOLUME /root/.m2

WORKDIR /usr/src/boot-docker-tryer

COPY . /usr/src/boot-docker-tryer/

CMD ["mvn", "spring-boot:run"]