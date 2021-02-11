FROM maven:3.6.1-jdk-8-alpine as jwt-app

WORKDIR /jwtapp

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src src

RUN mvn install -DskipTests

# Unzip
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)


## stage 2

FROM openjdk:17-jdk-alpine

VOLUME /tmp

ARG DEPENDENCY=/jwtapp/target/dependency

EXPOSE 8080

COPY --from=jwt-app ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=jwt-app ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=jwt-app ${DEPENDENCY}/BOOT-INF/classes /app

ADD ./spring-jwt/target/*.jar app.jar

ENTRYPOINT ["java","-cp","app:app/lib/*","com.javatoken.springjwt.SpringJwtApplication"]