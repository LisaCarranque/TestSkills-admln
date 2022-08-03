FROM java:8
VOLUME /tmp
EXPOSE 8081
ADD /build/libs/candidate-1.0.0.jar candidate-1.0.0.jar
ENTRYPOINT ["java","-jar","candidate-1.0.0.jar"]