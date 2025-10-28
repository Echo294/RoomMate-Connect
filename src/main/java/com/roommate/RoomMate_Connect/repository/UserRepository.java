package com.roommate.RoomMate_Connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roommate.RoomMate_Connect.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
	

}
