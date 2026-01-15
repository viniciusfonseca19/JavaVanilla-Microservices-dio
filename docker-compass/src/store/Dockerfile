FROM openjdk:24

WORKDIR /app
COPY src/store/ ProductsService.java

RUN javac ProductService.java

EXPOSE 8082
CMD ["java", "ProductService"]
