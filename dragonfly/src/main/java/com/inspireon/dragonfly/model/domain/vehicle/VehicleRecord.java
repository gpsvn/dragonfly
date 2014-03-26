package com.inspireon.dragonfly.model.domain.vehicle;

import java.util.Date;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.inspireon.dragonfly.model.domain.shared.Entity;

@Document(collection="records")
public class VehicleRecord extends Entity<VehicleRecord>{
	
	private String sim;
	
	@Indexed
	private Date timestamp;
	
	private Double longitude;
	
	private Double latitude;
	
	private Double speed;
	
	private Double direction;
	
	private Status status;
	

	public VehicleRecord(String sim, Date timestamp, Double longitude,
			Double latitude, Double speed, Status status) {
		super();
		this.sim = sim;
		this.timestamp = timestamp;
		this.longitude = longitude;
		this.latitude = latitude;
		this.speed = speed;
		this.status = status;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public Double getDirection() {
		return direction;
	}

	public void setDirection(Double direction) {
		this.direction = direction;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public boolean sameIdentityAs(VehicleRecord other) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
