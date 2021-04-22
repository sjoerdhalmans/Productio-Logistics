FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
RUN bash -c 'touch target/app.jar'
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=local","target/app.jar"]

EXPOSE 8086