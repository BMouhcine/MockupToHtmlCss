FROM java:8
EXPOSE 8080
ADD /target/mockup2html-0.0.1-SNAPSHOT.jar mockup2html-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "mockup2html-0.0.1-SNAPSHOT.jar"]