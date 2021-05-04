FROM openjdk:8
ADD target/event-management-demo.jar /app/event-management-demo.jar
EXPOSE 8080
WORKDIR /app
CMD  java -jar event-management-demo.jar