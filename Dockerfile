FROM maven:3.6.3-jdk-11-slim AS build
RUN mkdir /home/maven
WORKDIR /home/maven
COPY pom.xml /home/maven
COPY src /home/maven/src
RUN mvn -B -f pom.xml clean package -DskipTests

FROM openjdk:17-ea-22-jdk-oracle
RUN mkdir /app
COPY --from=build /home/maven/target/*.jar snyk-demo-app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","snyk-demo-app.jar"]