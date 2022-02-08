#FROM openjdk
FROM adoptopenjdk/openjdk11
#FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/mongo-spring-data.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
