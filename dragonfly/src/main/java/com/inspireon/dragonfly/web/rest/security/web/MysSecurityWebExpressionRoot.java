package com.inspireon.dragonfly.web.rest.security.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;

import com.inspireon.dragonfly.model.domain.user.Role;
import com.inspireon.dragonfly.web.rest.security.MysSecurityManager;
import com.inspireon.dragonfly.web.rest.shared.context.MysAction;
import com.inspireon.dragonfly.web.rest.shared.context.MysObject;
import com.inspireon.dragonfly.web.rest.shared.context.MystoryUser;

public class MysSecurityWebExpressionRoot extends WebSecurityExpressionRoot{

    private MysSecurityManager mysSecurityManager;
    
	public MysSecurityWebExpressionRoot(Authentication auth, FilterInvocation fi) {
		super(auth, fi);
	}
	
	public boolean hasPermis(String mysObj, String mysAct) {
		Object user = this.getPrincipal();
		if (user instanceof MystoryUser) {
			return mysSecurityManager.hasPermis(Role.getByKey(((MystoryUser)user).getRole()), 
												MysObject.getByValue(mysObj), MysAction.getByValue(mysAct));	
		} else { //GUEST
			return mysSecurityManager.hasPermis(Role.GUEST, MysObject.getByValue(mysObj), MysAction.getByValue(mysAct));
		}		
	}

	public void setMysSecurityManager(MysSecurityManager mysSecurityManager) {
		this.mysSecurityManager = mysSecurityManager;
	}
}