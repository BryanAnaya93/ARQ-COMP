FROM openjdk:11
ADD target/dashboard.jar dasboard.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "dasboard.jar"]