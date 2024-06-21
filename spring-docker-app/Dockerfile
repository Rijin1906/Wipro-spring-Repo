#pull docker image for JDK17 from DockerHub
#FROM openjdk:17-jdk-slim
FROM openjdk:17
#copy the jar file which is target folder into the container
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} spring-docker-app.jar
ENTRYPOINT ["java","-jar","/spring-docker-app.jar"]
#Expose port 9091 to applications running outside the container
#This instruction is optional, the port specified in application.properties file
#is implicitly exposed
#EXPOSE 9091
