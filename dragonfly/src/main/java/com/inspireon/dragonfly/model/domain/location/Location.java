package com.inspireon.dragonfly.model.domain.location;

public class Location {
	public static final float RADIUS = 6371f;
	
	private Float longitude;
	
	private Float latitude;
	
	private String locatingInformation;
	
	public Location(Float longitude, Float latitude, String locatingInformation) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.locatingInformation = locatingInformation;
	}

	public Float getLongitude(){
		return longitude;
	}
	
	public Float getLatitude(){
		return latitude;
	}
	
	public double distanceTo(Location otherLocation) {
		
		double lat1 = Math.toRadians(this.latitude);
		double lat2 = Math.toRadians(otherLocation.getLatitude());
		double lon1 = Math.toRadians(this.longitude);
		double lon2 = Math.toRadians(otherLocation.getLongitude());
		
		return  Math.acos(Math.sin(lat1) * Math.sin(lat2) + 
                	      Math.cos(lat1) * Math.cos(lat2) * 
                          Math.cos(lon2 - lon1)) * RADIUS;
		
	}
}
