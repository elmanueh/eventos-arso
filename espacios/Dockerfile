FROM maven:3.9.9 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM tomcat:9.0-jdk17
WORKDIR /usr/local/tomcat/webapps
RUN sed -i 's/8080/8081/' /usr/local/tomcat/conf/server.xml
COPY --from=build /app/target/espacios-0.0.1-SNAPSHOT.war ./ROOT.war
EXPOSE 8081
CMD ["catalina.sh", "run"]