# 1. பில்ட் ஸ்டேஜ்: மெவன் மூலம் அப்ளிகேஷனை பில்ட் செய்ய
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# 2. ரன் ஸ்டேஜ்: பில்ட் ஆன ஜாரை ரன் செய்ய
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]