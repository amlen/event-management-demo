FROM openjdk:8
ADD target/event-management-demo.jar event-management-demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "event-management-demo.jar"]