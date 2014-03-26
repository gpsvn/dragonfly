package com.inspireon.dragonfly.application;

import com.inspireon.dragonfly.exception.InvalidPasswordException;
import com.inspireon.dragonfly.exception.UserNotFoundException;
import com.inspireon.dragonfly.model.domain.user.User;

public interface UserService {
	
	boolean checkUnique(String username);
	
	boolean checkUniqueEmail(String email);
	
	boolean activate(String userId);

	
	public boolean resetPassword(String email);
	
	public void changePassword(String userName, String oldPassword, String newPassword)
						throws UserNotFoundException, InvalidPasswordException;
	
	/**
	 * Get User information and get rank based on number of likes. 
	 * @param username
	 * @return
	 */
	User getUserInfo(String username) throws UserNotFoundException;
}
