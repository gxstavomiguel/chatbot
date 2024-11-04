package main.java.com.chatbot.model;

public class Message {
    private String content;
    private String sender;

    public Message(String content, String sender){
        this.content = content;
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
