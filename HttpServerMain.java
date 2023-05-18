import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class HttpServerMain {

    public static void main(String[] args) throws IOException {
        final int PUERTO = 8000;
        HttpServer httpd = HttpServer.create(new InetSocketAddress(PUERTO), 0);
        HttpContext context = httpd.createContext("/");
        context.setHandler(HttpServerMain::handleRequest);
        httpd.start();
    }
        private static void handleRequest(HttpExchange exchange) throws IOException {
            final int COD_RESPONSE = 200;
            String content = "GO del server ;)";

        exchange.sendResponseHeaders(COD_RESPONSE, content.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(content.getBytes());
            os.close();
        }
    }
