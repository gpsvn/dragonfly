package com.inspireon.dragonfly.application;


public interface SecurityService {
	boolean checkStoryAuthorByTitle(String storyTitle, String editor);
	
	boolean checkStoryAuthor(String storyId, String editor);
	
	boolean checkCommentAuthor(String commentId, String editor);
	
	boolean checkUserValid(String username, String password);
}
