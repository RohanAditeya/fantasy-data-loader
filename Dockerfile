FROM amazoncorretto:21.0.1
COPY ./target/fantasy-data-loader-1.0-SNAPSHOT.jar /app/
WORKDIR /app/
RUN jar -xvf /app/fantasy-data-loader-1.0-SNAPSHOT.jar
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]