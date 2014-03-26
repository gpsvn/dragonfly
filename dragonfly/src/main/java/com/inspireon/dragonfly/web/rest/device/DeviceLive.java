package com.inspireon.dragonfly.web.rest.device;

import java.util.Date;

import com.inspireon.dragonfly.model.domain.device.Device;
import com.inspireon.dragonfly.model.domain.vehicle.VehicleRecord;

public class DeviceLive {
	
	private Device device;
	
	private VehicleRecord record;

	public DeviceLive(Device device, VehicleRecord record){
		this.device = device;
		this.record = record;
	}

	public String getDeviceType() {
		return device.getDeviceType();
	}

	public String getSim() {
		return device.getSim();
	}

	public String getPlateNumber() {
		return device.getPlateNumber();
	}

	public String getCarModel() {
		return device.getCarModel();
	}


	public Date getTimestamp() {
		return record.getTimestamp();
	}

	public Double getLongitude() {
		return record.getLongitude();
	}

	public Double getLatitude() {
		return record.getLatitude();
	}

	public Double getSpeed() {
		return record.getSpeed();
	}

	public int getDirection() {
		return ((int)(record.getDirection()/15))*15;
	}

	public String getStatus() {
		return "Not available";
	}

}
