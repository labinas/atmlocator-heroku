FROM openjdk:8
EXPOSE 9000
ADD target/atmlocator.jar atmlocator.jar
ENTRYPOINT ["java","-jar","/atmlocator.jar"]