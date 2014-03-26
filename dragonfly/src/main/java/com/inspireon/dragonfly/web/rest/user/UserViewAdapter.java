package com.inspireon.dragonfly.web.rest.user;

import java.io.Serializable;

import com.inspireon.dragonfly.common.util.DateUtils;
import com.inspireon.dragonfly.model.domain.user.User;

/**
 * View adapter for displaying information about one user, which other users can see on his/her profile page
 * @author Tung
 *
 */
public class UserViewAdapter implements Serializable {

	private static final long serialVersionUID = 8579225858950462657L;
	
	// Should User implement Serializable interface?  
	private final User user;
	private String viewer;

	public UserViewAdapter(User user) {
		this.user = user;
	}
	
	public UserViewAdapter(User user, String viewer) {
		this.user = user;
		this.viewer = viewer;
	}
	
	public String getUsername() {
		return user.username();
	}
	
	public String getJoinedDate() {
		// return user's joined date with "HH:mm:ss ngày dd/MM/yyyy" format
		return DateUtils.dateToViString(user.joinedDate());
	}
	
}
