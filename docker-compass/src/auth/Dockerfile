FROM openjdk:24

WORKDIR /app
COPY src/auth/ UsersService.java

RUN javac UsersService.java

EXPOSE 8081
CMD ["java", "UsersService"]
