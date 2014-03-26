package com.inspireon.dragonfly.persistence.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.inspireon.dragonfly.model.domain.device.Device;
import com.inspireon.dragonfly.model.domain.device.DeviceRepo;
import com.inspireon.dragonfly.persistence.BaseRepoImpl;

@Repository
public class DeviceRepoImpl extends BaseRepoImpl<Device, String> implements 
	DeviceRepo{

	@Override
	public List<Device> findByUser(String user) {
		
		Criteria criteria = new Criteria();
		
		criteria = criteria.and("customer").is(user);
		
		return getTemplate().find(new Query().addCriteria(criteria), Device.class);

	}

	
}
