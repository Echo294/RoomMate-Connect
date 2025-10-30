package com.roommate.RoomMate_Connect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomController {

    @GetMapping("/room")
    public String room() {
        // returns the Thymeleaf template named 'room.html' located in src/main/resources/templates
        return "room";
    }
}
