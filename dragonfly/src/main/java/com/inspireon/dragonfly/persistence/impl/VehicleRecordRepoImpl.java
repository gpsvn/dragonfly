package com.inspireon.dragonfly.persistence.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.inspireon.dragonfly.model.domain.vehicle.VehicleRecord;
import com.inspireon.dragonfly.model.domain.vehicle.VehicleRecordRepo;
import com.inspireon.dragonfly.persistence.BaseRepoImpl;

@Repository
public class VehicleRecordRepoImpl extends BaseRepoImpl<VehicleRecord, String> implements 
	VehicleRecordRepo{

	@Override
	public VehicleRecord findLatest() {
		return getTemplate().find(new Query()
		.addCriteria(Criteria.where("sim").is("1642756747"))
		.with(new Sort(Sort.Direction.DESC, "timestamp")).limit(1), VehicleRecord.class).get(0);
	}
	
	@Override
	public VehicleRecord findLatestById(String sim) {
		List<VehicleRecord> records = getTemplate().find(new Query()
		.addCriteria(Criteria.where("sim").is(sim))
		.with(new Sort(Sort.Direction.DESC, "timestamp")).limit(1), VehicleRecord.class);
		if(records != null && records.size()>0) return records.get(0);
		else return null;
	}
}
