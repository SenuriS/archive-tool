FROM openjdk:22-jdk
EXPOSE 8090
ARG JAR_FILE=archive-tool-master/target/*.jar
ADD ${JAR_FILE} master.jar
ENTRYPOINT ["java","-jar","/master.jar"]