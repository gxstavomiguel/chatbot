package main.java.com.chatbot.repository;

import main.java.com.chatbot.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageRepository {
    private List<Message> messages = new ArrayList<>();

    public void save(Message message){
        messages.add(message);
    }

    public List<Message> findAll(){
        return messages;
    }

}
