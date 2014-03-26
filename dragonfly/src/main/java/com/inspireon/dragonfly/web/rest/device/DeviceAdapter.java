package com.inspireon.dragonfly.web.rest.device;

import java.util.Date;

import com.inspireon.dragonfly.model.domain.device.Device;

public class DeviceAdapter {
	
	private Device device;

	public DeviceAdapter(Device device){
		this.device = device;
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

	public String getCustomer() {
		return device.getCustomer();
	}

	public String getVIN() {
		return device.getVIN();
	}

	public String getNote() {
		return device.getNote();
	}

	public Date getCreatedDate() {
		return device.getCreatedDate();
	}

	public String getCreator() {
		return device.getCreator();
	}
}
