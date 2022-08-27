FROM openjdk:8-jdk-alpine
ADD target/devops_intigration_update-0.0.1.jar devops_intigration_update-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "devops_intigration_update-0.0.1.jar"]