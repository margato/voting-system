FROM adoptopenjdk/openjdk11:alpine

ENV TZ=GMT-3
ARG JAR_FILE=target/*.jar
RUN mkdir app
RUN apk add busybox-extras

COPY ${JAR_FILE} /app/voteconsolidation.jar

ENTRYPOINT ["java", "-jar", "./app/voteconsolidation.jar"]