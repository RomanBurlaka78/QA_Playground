FROM maven:3.9.6-eclipse-temurin-17-alpine

WORKDIR /app

COPY . .

CMD ["mvn", "test"]