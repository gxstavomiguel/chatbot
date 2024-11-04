package main.java.com.chatbot.service;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.Request;
import main.java.com.chatbot.controller.ChatBotController;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class ChatBotService {
    private static final int PORT = 8080;
    private static ChatBotController chatbotController = new ChatBotController(new ChatBotService(new MessageProcessor()));

    public static void main(String[] args)throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        server.createContext("/chat", new ChatHandler());
        server.setExecutor(null);
        System.out.println("Servidor rodando na porta " + PORT);
        server.start();
    }

    static class ChatHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            if ("POST".equals(exchange.getRequestMethod())){
               String requestBody = new String(exchange.getRequestBody().readAllBytes());
               String userMessage = new Gson().fromJson(requestBody, Request.class).message;

               String botResponse = chatbotController.receiveMessage(userMessage);

               Response response = new Response(botResponse);
               String jsonResponse = new Gson().toJson(response);

               exchange.getResponseHeaders().set("Content-Type", "application/json");
               exchange.sendResponseHeaders(200, jsonResponse.getBytes().length);

                OutputStream os = exchange.getResponseBody();
                os.write(jsonResponse.getBytes());
                os.close();
            }
        }
    }

    static class Request {
        String message;
    }

    static class Response{
        String response;

        Response(String response){
            this.response = response;
        }
    }
}
