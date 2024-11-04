package main.java.com.chatbot;

import main.java.com.chatbot.controller.ChatBotController;
import main.java.com.chatbot.service.ChatBotService;
import main.java.com.chatbot.service.MessageProcessor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MessageProcessor processor = new MessageProcessor();
        ChatBotService chatbotService = new ChatBotService(processor);
        ChatBotController chatbotController = new ChatBotController(chatbotService);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bot: Olá! Como posso ajudar?");

        while (true) {
            System.out.println("Você: ");
            String userMessage = scanner.nextLine();

            if (userMessage.equalsIgnoreCase("sair")) {
                break;
            }

            String botResponse = chatbotController.receiveMessage(userMessage);
            System.out.println("Bot: " + botResponse);
        }
        scanner.close();

    }
}
