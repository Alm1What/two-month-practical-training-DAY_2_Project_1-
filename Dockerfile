FROM eclipse-temurin:21-jdk

COPY target/day_2_pratctice_project_one-0.0.1-SNAPSHOT.jar app.jar


ENTRYPOINT ["java","-jar","/app.jar"]