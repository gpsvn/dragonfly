package com.inspireon.dragonfly.web.rest.user;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inspireon.dragonfly.application.UserService;
import com.inspireon.dragonfly.web.rest.base.AbstractBaseController;

@Controller
@RequestMapping("/account")
public class UserProfileController extends AbstractBaseController{
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired		
	private UserService userService;
		
	
}
