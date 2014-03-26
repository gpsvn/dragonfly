package com.inspireon.dragonfly.persistence;

import com.inspireon.dragonfly.model.domain.user.User;

public class MockObjectUtils {
	public static User createUser(String username, String password, String email){
		User user = new User(username, password, email);
		
		return user;
	}
}
