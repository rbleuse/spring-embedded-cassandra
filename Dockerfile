FROM azul/zulu-openjdk-alpine:17.0.3 AS build
RUN apk add --no-cache openjdk8
ENV JAVA_HOME=/usr/lib/jvm/zulu17-ca
ENV JAVA_8_HOME=/usr/lib/jvm/java-1.8-openjdk
COPY . /src
WORKDIR /src
RUN ./gradlew clean build --no-daemon --info

FROM azul/zulu-openjdk-alpine:17.0.3-jre

EXPOSE 8080

COPY --from=build /src/build/libs/*.jar app.jar

# Execute the application JAR file
ENTRYPOINT exec java $JAVA_OPTS $APP_OPTS -jar app.jar
