package auth;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class UsersServices {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8081), 0);
        server.createContext("/users", new UsersHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Users service running on port 8081");
    }

    static class UsersHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws java.io.IOException {
            String response = "[{\"id\":1,\"name\":\"Vini\"},{\"id\":2,\"name\":\"João\"}]";

            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.getBytes().length);

            OutputStream os = exchange.getResponseBody();

            os.write(response.getBytes());
            os.close();
        }
    }
}
