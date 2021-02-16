FROM timbru31/java-node:11-jdk as builder
WORKDIR application
COPY . .
RUN ls -lar
RUN yarn --cwd web
RUN yarn --cwd web build
RUN ./gradlew
ARG JAR_FILE=api/build/libs/*.jar
RUN cp $JAR_FILE application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM adoptopenjdk:11-jre-hotspot
WORKDIR application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
