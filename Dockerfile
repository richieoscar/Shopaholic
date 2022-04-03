FROM openjdk:11
WORKDIR /app
EXPOSE 8080
ADD /target/shopaholic-app.jar /app/shopaholic-app.jar
ENTRYPOINT ["java", "-jar", "/app/shopaholic-app.jar"]