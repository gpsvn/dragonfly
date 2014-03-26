package com.inspireon.dragonfly.model.domain.user;

import java.util.List;

import com.inspireon.dragonfly.persistence.BaseRepo;

public interface UserRepo extends BaseRepo<User, String> {
	
	User findByEmail(String email);
	
	User findByUsername(String username);
	
	List<User> findTopStoryTellers();
	
	User findUserByAvatar(String avatar);
}
