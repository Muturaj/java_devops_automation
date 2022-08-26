FROM openjdk:8-jdk-alpine
ADD target/devops_intigration.jar devops_intigration.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "devops_intigration.jar"]