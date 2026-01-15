FROM openjdk:24

WORKDIR /app
COPY src/gateway/ Gateway.java

RUN javac Gateway.java

EXPOSE 8080
CMD ["java", "Gateway"]
