FROM openjdk:17
ARG JAR_FILE=build/libs/sodam-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} sodam.jar
ENTRYPOINT ["java","-jar","/sodam.jar"]