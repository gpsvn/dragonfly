package com.inspireon.dragonfly.web.rest.security;

import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;

import com.inspireon.dragonfly.application.SecurityService;

public class MysSecurityExpressionRoot extends SecurityExpressionRoot 
				implements MethodSecurityExpressionOperations {
    private Object filterObject;
    private Object returnObject;
    private Object target;
    private MysSecurityManager mysSecurityManager;
    private SecurityService securityService;
    
	public MysSecurityExpressionRoot(Authentication auth) {
		super(auth);
	}		
	
	/*
	 **********************************************************************************************************
	 ***************************************** MYSTORY SECURITY METHODS ***************************************
	 **********************************************************************************************************
	 */
	
	/*
	 **********************************************************************************************************
	 ***************************************** END ************************************************************
	 **********************************************************************************************************
	 */
	
	@Override
	public boolean hasPermission(Object mysObj, Object mysAct) {
		return false;
	}
	
	@Override
	public boolean hasPermission(Object targetId, String targetType,
			Object permission) {
		return false;
	}	
	
	@Override
	public void setFilterObject(Object filterObject) {
		this.filterObject = filterObject;
	}
	
	@Override
	public Object getFilterObject() {
		return filterObject;
	}
	
	@Override
	public void setReturnObject(Object returnObject) {
		this.returnObject = returnObject;
	}
	
	@Override
	public Object getReturnObject() {
		return returnObject;
	}

	public void setThis(Object target) {
		this.target = target;
	}
	
	@Override
	public Object getThis() {
		return target;
	}
	
	public void setMysSecurityManager(MysSecurityManager mysSecurityManager) {
		this.mysSecurityManager = mysSecurityManager;
	}

	public void setSecurityService(SecurityService securityService) {
		this.securityService = securityService;
	}	
}