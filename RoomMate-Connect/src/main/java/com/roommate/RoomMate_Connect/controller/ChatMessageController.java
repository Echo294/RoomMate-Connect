package com.roommate.RoomMate_Connect.controller;

import com.roommate.RoomMate_Connect.model.ChatMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

@Controller
public class ChatMessageController {

    @MessageMapping("/chat.send")
    @SendTo("/topic/messages")
    public ChatMessage receiveMessage(ChatMessage message) {
        // Here you would typically process the message, e.g., save it to a database or broadcast it
        System.out.println("Received message from " + message.getSender() + ": " + message.getContent() + " in room " + message.getRoom());
        return message;
    }
    
}
