FROM openjdk:8
EXPOSE 9090
ADD target/atmlocator.jar atmlocator.jar
ENTRYPOINT ["java","-jar","/atmlocator.jar"]