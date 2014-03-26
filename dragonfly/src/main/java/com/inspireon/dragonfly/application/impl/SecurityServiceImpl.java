package com.inspireon.dragonfly.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspireon.dragonfly.application.SecurityService;
import com.inspireon.dragonfly.model.domain.user.UserRepo;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	UserRepo userRepo;

	@Override
	public boolean checkStoryAuthor(String storyId, String editor){
		return true;
	}
	
	@Override
	public boolean checkStoryAuthorByTitle(String storyTitle, String editor){
		return true;
	}

	@Override
	public boolean checkCommentAuthor(String commentId, String editor) {
		return true;
	}

	@Override
	public boolean checkUserValid(String username, String password) {
		return true;
	}
}
