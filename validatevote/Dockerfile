FROM adoptopenjdk/openjdk11:alpine

ENV TZ=GMT-3
ARG JAR_FILE=target/*.jar
RUN mkdir app
RUN apk add busybox-extras

COPY ${JAR_FILE} /app/validatevote.jar

ENTRYPOINT ["java", "-jar", "./app/validatevote.jar"]