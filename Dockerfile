FROM openjdk:17
LABEL maintainer="api-rate-limiter"
ADD target/api-rate-limiter-0.0.1-SNAPSHOT.jar app.jar
COPY target/api-rate-limiter-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8090
ENTRYPOINT [ "java","-jar","app.jar" ]