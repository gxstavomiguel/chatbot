package main.java.com.chatbot.service;

import java.util.HashMap;
import java.util.Map;

public class MessageProcessor {
    private Map<String, String> keywordResponses;

    public MessageProcessor() {
        keywordResponses = new HashMap<>();
        initializeResponse();
    }

    private void initializeResponse() {
        keywordResponses.put("oi", "Olá! Como posso ajudar?");
        keywordResponses.put("bom dia", "Bom dia! Como posso ajudar?");
        keywordResponses.put("boa tarde", "Boa Tarde! Como posso ajudar?");
        keywordResponses.put("boa noite", "Boa Noite! Como posso ajudar?");
        keywordResponses.put("preciso de ajuda", "Entendi, vou te redirecionar para um atendente.");

    }

    public String process(String userMessage) {
        for (String keyword : keywordResponses.keySet()) {
            if (userMessage.toLowerCase().contains(keyword)) {
                return keywordResponses.get(keyword);
            }
        }
        return "Não consegui identificar!";
    }


}
