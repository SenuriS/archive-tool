FROM openjdk:22-jdk
EXPOSE 8091
ARG JAR_FILE=archive-tool-source/target/*.jar
ADD ${JAR_FILE} source.jar
ENTRYPOINT ["java","-jar","/source.jar"]