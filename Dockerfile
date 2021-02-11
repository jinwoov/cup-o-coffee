FROM openjdk:17-jdk-alpine

VOLUME /tmp

EXPOSE 8080

ADD /spring-jwt/target/*.jar /app.jar

ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]