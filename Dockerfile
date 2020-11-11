FROM openjdk:8-jre-alpine
RUN apk add --no-cache curl
COPY target/ExchangeRateService.jar /ExchangeRateService.jar
EXPOSE 8085
CMD ["java", "-jar", "/ExchangeRateService.jar"]



