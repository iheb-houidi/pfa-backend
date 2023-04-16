FROM openjdk:17-alpine
EXPOSE 8080
ADD target/ProjectForPfa-0.0.1-SNAPSHOT.jar ProjectForPfa-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/ProjectForPfa-0.0.1-SNAPSHOT.jar"]