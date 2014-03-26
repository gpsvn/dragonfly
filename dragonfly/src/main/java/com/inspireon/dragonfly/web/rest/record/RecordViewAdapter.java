package com.inspireon.dragonfly.web.rest.record;

import com.inspireon.dragonfly.model.domain.vehicle.VehicleRecord;

public class RecordViewAdapter {
	
	private VehicleRecord vehicleRecord;
	
	public RecordViewAdapter(VehicleRecord vehicleRecord){
		this.vehicleRecord  = vehicleRecord;
	}

	public String getSim() {
		return vehicleRecord.getSim();
	}


	public String getPlateNumber() {
		return "chua co bien so";
	}

	public double getLongitude() {
		return vehicleRecord.getLongitude();
	}

	public double getLatitude() {
		return vehicleRecord.getLatitude();
	}

	public double getSpeed() {
		return vehicleRecord.getSpeed();
	}
	
}
