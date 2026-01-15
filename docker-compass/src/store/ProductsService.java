package store;

import java.util.*;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class ProductsService {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8082), 0);
        server.createContext("/products", new ProductsHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Products service running on port 8082");
    }

    static class ProductsHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws java.io.IOException {
            String response = "[{\"id\":1,\"name\":\"Shuriken\"},{\"id\":2,\"name\":\"Katana\"}]";

            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.getBytes().length);

            OutputStream os = exchange.getResponseBody();

            os.write(response.getBytes());
            os.close();
        }
    }
}
