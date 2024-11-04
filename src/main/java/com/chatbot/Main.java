package main.java.com.chatbot;

import main.java.com.chatbot.controller.ChatBotController;
import main.java.com.chatbot.service.ChatBotService;
import main.java.com.chatbot.service.MessageProcessor;

public class Main {
    public static void main(String[] args) {
        MessageProcessor processor = new MessageProcessor();
        ChatBotService chatbotService = new ChatBotService(processor);
        ChatBotController chatbotController = new ChatBotController(chatbotService);

        String userMessage = "Olá";
        String botResponse = chatbotController.receiveMessage(userMessage);
        System.out.println("Bot: " + botResponse);
    }
}
