#Chez benoit, commande :
# docker buildx build -t app-image . --builder "$(docker buildx create --driver-opt env.BUILDKIT_STEP_LOG_MAX_SIZE=10000000 --driver-opt env.BUILDKIT_STEP_LOG_MAX_SPEED=10000000)"

FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/*.jar /usr/local/lib/app.jar
EXPOSE 8087
CMD ["java", "-jar", "/usr/local/lib/app.jar"]