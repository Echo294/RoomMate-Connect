package com.roommate.RoomMate_Connect.repository;

import com.roommate.RoomMate_Connect.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
    ChatRoom findByName(String name);
}
