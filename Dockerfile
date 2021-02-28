
#
# Build
#
FROM gradle:6.8.2-jdk8 AS BUILD

COPY --chown=gradle:gradle src /home/gradle/src
COPY --chown=gradle:gradle build.gradle /home/gradle
COPY --chown=gradle:gradle gradle.properties /home/gradle
COPY --chown=gradle:gradle settings.gradle /home/gradle

RUN gradle bootJar --no-daemon

#
# Package stage
#
FROM openjdk:8-jre-slim AS PRODUCT_JAR

WORKDIR /app

COPY --from=build /home/gradle/build/libs /app/build/libs

RUN ls -r build/libs

EXPOSE 8090
ENTRYPOINT ["java", "-jar", "build/libs/product-catalog-1.0.0.jar" ]

