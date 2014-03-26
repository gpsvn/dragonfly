package com.inspireon.dragonfly.model.domain.vehicle;

import com.inspireon.dragonfly.persistence.BaseRepo;

public interface VehicleRecordRepo extends BaseRepo<VehicleRecord, String>{

	public VehicleRecord findLatest();
	
	public VehicleRecord findLatestById(String sim);
}
