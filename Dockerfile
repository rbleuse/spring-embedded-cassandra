FROM azul/zulu-openjdk:17.0.3
RUN apt-get update && apt-get install -y zulu8-ca-jdk
ENV JAVA_8_HOME=/usr/lib/jvm/zulu8
COPY . /src
WORKDIR /src
RUN ./gradlew clean test --no-daemon --info
