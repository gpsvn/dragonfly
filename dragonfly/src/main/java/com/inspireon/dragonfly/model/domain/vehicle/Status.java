package com.inspireon.dragonfly.model.domain.vehicle;

public class Status {
	
	private boolean ignition; 
	
	private boolean engine;
	
	private boolean brake;
	
	private boolean airCondition;
	
	private boolean vehicleDoor;
	
	private boolean vehicleState;
	
	private boolean power;
	
	private boolean sOS;
	
	private boolean overspeed;
	
	private boolean firmwareUpdateStatus;
	
	private boolean ctrl01;
	
	private boolean ctrl02;
	
	private boolean ctrl03; 
	
	private boolean sPSSignal;
	
	private boolean sSMSignal;
	
	private boolean camHL02ID1Use;
	
	private boolean camHL02ID2Use;
	
	private boolean camHL02ID3Use;
	
	private boolean camHL02ID4Use;
	
	private boolean camHL02ID1Work;
	
	private boolean camHL02ID2Work;
	
	private boolean camHL02ID3Work;
	
	private boolean camHL02ID4Eork;
	
	public Status(boolean ignition, boolean engine, boolean brake,
			boolean airCondition, boolean vehicleDoor, boolean vehicleState,
			boolean power, boolean sOS, boolean overspeed,
			boolean firmwareUpdateStatus, boolean ctrl01, boolean ctrl02,
			boolean ctrl03, boolean sPSSignal, boolean sSMSignal,
			boolean camHL02ID1Use, boolean camHL02ID2Use,
			boolean camHL02ID3Use, boolean camHL02ID4Use,
			boolean camHL02ID1Work, boolean camHL02ID2Work,
			boolean camHL02ID3Work, boolean camHL02ID4Eork) {
		this.ignition = ignition;
		this.engine = engine;
		this.brake = brake;
		this.airCondition = airCondition;
		this.vehicleDoor = vehicleDoor;
		this.vehicleState = vehicleState;
		this.power = power;
		this.sOS = sOS;
		this.overspeed = overspeed;
		this.firmwareUpdateStatus = firmwareUpdateStatus;
		this.ctrl01 = ctrl01;
		this.ctrl02 = ctrl02;
		this.ctrl03 = ctrl03;
		this.sPSSignal = sPSSignal;
		this.sSMSignal = sSMSignal;
		this.camHL02ID1Use = camHL02ID1Use;
		this.camHL02ID2Use = camHL02ID2Use;
		this.camHL02ID3Use = camHL02ID3Use;
		this.camHL02ID4Use = camHL02ID4Use;
		this.camHL02ID1Work = camHL02ID1Work;
		this.camHL02ID2Work = camHL02ID2Work;
		this.camHL02ID3Work = camHL02ID3Work;
		this.camHL02ID4Eork = camHL02ID4Eork;
	}
}
