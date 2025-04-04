FROM maven:3.9.9
WORKDIR /app
COPY . .
EXPOSE 8081
ENTRYPOINT ["mvn", "jetty:run"]