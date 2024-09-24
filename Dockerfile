FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/SpringDemoBot-0.0.1-SNAPSHOT.jar /app/SpringDemoBot.jar
CMD ["java", "-jar", "/app/SpringDemoBot.jar"]
