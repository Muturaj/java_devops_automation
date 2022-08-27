FROM openjdk:8-jdk-alpine
ADD target/devops_intigration_update.jar devops_intigration_update.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "devops_intigration_update.jar"]