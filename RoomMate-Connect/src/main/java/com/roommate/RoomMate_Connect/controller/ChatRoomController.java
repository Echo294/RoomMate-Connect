package com.roommate.RoomMate_Connect.controller;

import com.roommatechat.model.ChatRoom;
import com.roommatechat.model.user;
import com.rommmatechat.repository.ChatRoomRepository;
import com.roommatechat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.list;
import java.util.optional;

@RestController
@RequestMapping("/rooms")
public class ChatRoomController {

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<ChatRoom> getAllChatRooms() {
        return chatRoomRepository.findAll();
    }

    @PostMapping
    public ChatRoom createChatRoom(@RequestBody ChatRoom newChatRoom) {
        return chatRoomRepository.save(newChatRoom);
    }

    @PostMapping("/{roomId}/addUser/{userId}")
    public ChatRoom addUserToChatRoom(@PathVariable Long roomId, @PathVariable Long userId) {
        Optional<ChatRoom> chatRoomOpt = chatRoomRepository.findById(roomId);
        Optional<user> userOpt = userRepository.findById(userId);

        if (chatRoomOpt.isPresent() && userOpt.isPresent()) {
            ChatRoom chatRoom = chatRoomOpt.get();
            user user = userOpt.get();
            chatRoom.getMembers().add(user);
            return chatRoomRepository.save(chatRoom);
        } else {
            throw new RuntimeException("ChatRoom or User not found");
        }
    }
    
}
