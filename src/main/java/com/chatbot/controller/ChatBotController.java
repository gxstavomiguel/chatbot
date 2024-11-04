package main.java.com.chatbot.controller;

import main.java.com.chatbot.service.ChatBotService;

public class ChatBotController {
    private final ChatBotService chatbotService;

        public ChatBotController(ChatBotService chatbotService){
            this.chatbotService = chatbotService;
        }
        public String receiveMessage(String userMessage){
            return chatbotService.generateResponse(userMessage);
        }
    }

