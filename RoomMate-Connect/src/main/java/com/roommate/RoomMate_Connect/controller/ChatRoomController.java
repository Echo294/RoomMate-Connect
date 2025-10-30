package com.roommate.RoomMate_Connect.controller;

import com.roommate.RoomMate_Connect.model.ChatRoom;
import com.roommate.RoomMate_Connect.model.User;
import com.roommate.RoomMate_Connect.repository.ChatRoomRepository;
import com.roommate.RoomMate_Connect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        Optional<User> userOpt = userRepository.findById(userId);

        if (chatRoomOpt.isPresent() && userOpt.isPresent()) {
            ChatRoom chatRoom = chatRoomOpt.get();
            User userEntity = userOpt.get();
            chatRoom.getMembers().add(userEntity);
            return chatRoomRepository.save(chatRoom);
        } else {
            throw new RuntimeException("ChatRoom or User not found");
        }
    }
    
}
