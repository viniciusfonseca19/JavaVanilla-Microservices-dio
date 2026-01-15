package gateway;

import java.util.*;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Gateway {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/users", new ProxyHandler("http://users-service:8081/users"));
        server.createContext("/products", new ProxyHandler("http://products-service:8082/products"));
        server.setExecutor(null);
        server.start();

        System.out.println("Gateway running on port 8080");
    }

    static class ProxyHandler implements HttpHandler {
        private final String targetUrl;

        public ProxyHandler(String targetUrl) {
            this.targetUrl = targetUrl;
        }

        @Override
        public void handle(HttpExchange exchange) throws java.io.IOException {
            try {
                URL url = new URL(targetUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                Scanner scanner = new Scanner(conn.getInputStream()).useDelimiter("\\A");
                String response = scanner.hasNext() ? scanner.next() : "";
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
                String response = "{\"error\":\"Service unavailable\"}";
                exchange.sendResponseHeaders(500, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }
}
