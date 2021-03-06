FROM openjdk:8-jre

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JAVA_OPTS=""
    
ADD *.jar app.jar

CMD echo "The application will start " && \
    java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.jar --server.port=8080

EXPOSE 8080