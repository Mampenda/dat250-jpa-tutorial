FROM eclipse-temurin:21
RUN mkdir /opt/app
COPY src/main/resources/dat250-jpa-tutorial.jar /opt/app
CMD ["java", "-jar", "/opt/app/japp.jar"]