package com.inspireon.dragonfly.model.domain.device;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.inspireon.dragonfly.model.domain.shared.Entity;

@Document(collection = "devices")
public class Device extends Entity<Device>{
	
	private String deviceType;
	
	private String sim;
	
	private String plateNumber;
	
	private String carModel;
	
	private String customer;
	
	private String VIN;
	
	private String note;
	
	private Date createdDate;
	
	private String creator;
	
	public Device(String deviceType, String sim, String plateNumber, String carModel,
			String customer, String VIN, String note, String creator){
		this.deviceType = deviceType;
		this.sim = sim;
		this.plateNumber = plateNumber;
		this.carModel = carModel;
		this.customer = customer;
		this.VIN = VIN;
		this.note = note;
		this.creator = creator;
		this.createdDate = new Date();
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getVIN() {
		return VIN;
	}

	public void setVIN(String vIN) {
		VIN = vIN;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Override
	public boolean sameIdentityAs(Device other) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String toString(){
		return ">>> deviceType: " + this.getDeviceType() + "|sim: " + this.getSim() + "|car model: " + this.getCarModel() + "" + this.getPlateNumber() + "|plate number: " + this.getPlateNumber();
	}
}
