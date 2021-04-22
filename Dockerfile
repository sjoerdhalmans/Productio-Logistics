FROM openjdk:11-oracle

COPY ./target/logistics-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch logistics-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","logistics-0.0.1-SNAPSHOT.jar"]

EXPOSE 8086