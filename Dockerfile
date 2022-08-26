FROM openjdk:8-jdk-alpine
ADD target/spring-boot-practice-kube.jar spring-boot-practice-kube.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring-boot-practice-kube.jar"]