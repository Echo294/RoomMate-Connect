package com.roommate.RoomMate_Connect.controller;

import com.roommatechat.RoomMate_Connect.model.ChatMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
public class ChatMessageController {

    @PostMapping("/chat/message")
    @ResponseBody
    public String receiveMessage(@RequestBody ChatMessage message) {
        // Here you would typically process the message, e.g., save it to a database or broadcast it
        System.out.println("Received message from " + message.getSender() + ": " + message.getContent() + " in room " + message.getRoom());
        return "Message received";
    }
    
}
