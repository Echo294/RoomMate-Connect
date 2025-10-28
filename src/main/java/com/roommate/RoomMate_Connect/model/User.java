package com.roommate.RoomMate_Connect.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Long is used because user ID can be long
	
	private String username;
	private String password;
	
	//Empty constructor because JPA requires
	public User() {}
	
	
	//constructor for easy creation of accounts
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Long getId() { return id; }
	public String getUsername() { return username; }
	public void setUsername(String username) {this.username = username; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

}
