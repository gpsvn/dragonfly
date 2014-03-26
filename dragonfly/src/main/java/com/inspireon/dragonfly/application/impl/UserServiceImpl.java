package com.inspireon.dragonfly.application.impl;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inspireon.dragonfly.application.ImageGroupService;
import com.inspireon.dragonfly.application.UserService;
import com.inspireon.dragonfly.exception.InvalidPasswordException;
import com.inspireon.dragonfly.exception.UserNotFoundException;
import com.inspireon.dragonfly.model.domain.image.ImageGroupRepo;
import com.inspireon.dragonfly.model.domain.user.User;
import com.inspireon.dragonfly.model.domain.user.UserRepo;
import com.inspireon.dragonfly.model.manager.BetaUserManager;
import com.inspireon.dragonfly.model.manager.UserManager;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private BetaUserManager betaUserManager;
	
	@Autowired
	private ImageGroupRepo imageGroupRepo;
	
	@Autowired
	private ImageGroupService imageGroupService;	
	
	/**
	 * @author Phuong
	 * 
	 */
	@Override
	public boolean resetPassword(String email) {
		
		User user = userRepo.findByEmail(email);
		
		if(user == null) return false;
		
		else{
			
			//generate new password
			String password = userManager.generateRandomPassword();
			try {
				//save new password
				user.resetPassword(password);
				userRepo.store(user);
				
				//email password to user
				userManager.emailPassword(email, password);
				
				return true;
				
			} catch (AddressException e) {
				if(logger.isDebugEnabled())
					logger.debug("Error sending email to " + email);
				return false;
			} catch (MessagingException e) {
				if(logger.isDebugEnabled())
					logger.debug("Error sending email to " + email);
				return false;
			}
		}
	}

	@Override
	public User getUserInfo(String username) throws UserNotFoundException{
		User user = userRepo.findByUsername(username);
		if (user == null) {
			// if user not found, then throw exception
			logger.debug("User not found: " + username);			
			throw new UserNotFoundException(username);
		} else {
			return user;
		}
	}	
	
	
	@Override
	public boolean checkUnique(String username) {
		User user = userRepo.findByUsername(username);
		if(user!=null) return false;
		return true;
	}

	@Override
	public void changePassword(String username, String oldPassword, String newPassword) 
			throws UserNotFoundException, InvalidPasswordException {
		User user = userRepo.findByUsername(username);
		if (user != null) {
			user.changePassword(oldPassword, newPassword);
			userRepo.store(user);
		} else {
			throw new UserNotFoundException(username);
		}
	}

	@Override
	public boolean checkUniqueEmail(String email) {
		User user = userRepo.findByEmail(email);
		if(user!=null) return false;
		return true;
	}

	@Override
	public boolean activate(String userId) {
		// TODO Auto-generated method stub
		return false;
	}
}
