FROM alpine:edge

RUN apk add --no-cache openjdk11
COPY target/*.jar /tmp
WORKDIR /tmp

CMD ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","./catalogador-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080