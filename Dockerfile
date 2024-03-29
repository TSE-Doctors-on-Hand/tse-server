FROM amazoncorretto:21-alpine-jdk
MAINTAINER cmp2804.tse
COPY build/libs/tse-server-0.0.1-SNAPSHOT.jar tse-server-1.0.0.jar
ENTRYPOINT ["java", "-jar", "/tse-server-1.0.0.jar"]