FROM openjdk:22-jdk
EXPOSE 8092
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} destination.jar
ENTRYPOINT ["java","-jar","/destination.jar"]