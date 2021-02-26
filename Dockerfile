
#
# Build
#
FROM gradle:6.8.2-jdk8 AS build

COPY --chown=gradle:gradle src /home/gradle/src
COPY --chown=gradle:gradle build.gradle /home/gradle
COPY --chown=gradle:gradle gradle.properties /home/gradle

RUN gradle build --no-daemon
RUN gradle wrapper --no-daemon

#
# Package stage
#
FROM openjdk:8-jre-slim

WORKDIR /app

COPY --from=build /home/gradle/build/libs /app/build/libs

RUN ls -r build/libs

EXPOSE 8090
ENTRYPOINT ["java", "-jar", "build/libs/gradle-1.0.0.jar" ]

