package main.java.com.chatbot.service;

public class ChatBotService {
    private final MessageProcessor messageProcessor;

    public ChatBotService(MessageProcessor messageProcessor){
        this.messageProcessor = messageProcessor;
    }

    public String generateResponse(String userMessage){
        return messageProcessor.process(userMessage);
    }

}
