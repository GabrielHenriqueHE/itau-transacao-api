FROM azul/zulu-openjdk-alpine:21

WORKDIR /app

COPY target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]