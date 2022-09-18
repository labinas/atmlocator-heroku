FROM openjdk:8
EXPOSE 8080
ADD target/atmlocator.jar atmlocator.jar
ENTRYPOINT ["java","-jar","/atmlocator.jar"]