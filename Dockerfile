FROM adoptopenjdk/openjdk11:latest
#RUN mkdir /opt/app
#WORKDIR /opt/app
#COPY . .
#RUN ./gradlew build && \
#    cp build/libs/spring-docker-practice-0.0.1-SNAPSHOT.jar .
ADD build/libs/spring-docker-practice-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
#CMD ["java", "-jar", "spring-docker-practice-0.0.1-SNAPSHOT.jar"]
