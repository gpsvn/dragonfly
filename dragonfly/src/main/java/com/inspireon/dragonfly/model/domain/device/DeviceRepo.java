package com.inspireon.dragonfly.model.domain.device;

import java.util.List;

import com.inspireon.dragonfly.persistence.BaseRepo;

public interface DeviceRepo extends BaseRepo<Device, String>{
	
	public List<Device> findByUser(String user);
	
}
