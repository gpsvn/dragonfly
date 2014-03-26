package com.inspireon.dragonfly.persistence.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.inspireon.dragonfly.model.domain.user.User;
import com.inspireon.dragonfly.model.domain.user.UserRepo;
import com.inspireon.dragonfly.persistence.BaseRepoImpl;

@Repository
public class UserRepoImpl extends BaseRepoImpl<User, String> implements UserRepo{

	@Override
	public User findByEmail(String email) {
		
		Query query = new Query();
		
		Criteria criteria = new Criteria();
		
		criteria = criteria.and("email").is(email);
		
		query.addCriteria(criteria);
		
		List<User> users = getTemplate().find(query, User.class);
		if(users != null && users.size() > 0)
			return users.get(0);
		else return null;
	}

	@Override
	public User findByUsername(String username) {
		Query query = new Query();
		
		Criteria criteria = new Criteria();
		
		criteria = criteria.and("username").is(username);
		
		query.addCriteria(criteria);
		
		List<User> users = getTemplate().find(query, User.class);
		if(users != null && users.size() > 0)
			return users.get(0);
		else return null;
	}
	
	@Override
	public List<User> findTopStoryTellers() {
		return getTemplate().find(new Query()
							.with(new Sort(Sort.Direction.DESC, "contribution.points"))
							.limit(5), User.class);
	}

	@Override
	public User findUserByAvatar(String avatar) {
		Query query = new Query();
		
		Criteria criteria = new Criteria();
		
		criteria = criteria.and("avatar.name").is(avatar);
		
		query.addCriteria(criteria);
		
		List<User> users = getTemplate().find(query, User.class);
		if(users != null && users.size() > 0)
			return users.get(0);
		else return null;
	}
}
