package com.inspireon.dragonfly.web.rest.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.inspireon.dragonfly.model.domain.user.User;
import com.inspireon.dragonfly.model.domain.user.UserRepo;
import com.inspireon.dragonfly.web.rest.shared.context.MystoryAuthority;
import com.inspireon.dragonfly.web.rest.shared.context.MystoryUser;


public class SpringUserService implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public MystoryUser loadUserByUsername(final String username)
			throws UsernameNotFoundException {
		
		User user = userRepo.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found!");
		} 
		
		List<MystoryAuthority> authorities  = new ArrayList<MystoryAuthority>();
		
		authorities.add(new MystoryAuthority(user.role().toString()));
		
		MystoryUser mystoryUser = new MystoryUser(user.id(), user.username(), user.password(), 
													user.role().toString(), authorities);
		
		return mystoryUser;
	}
}