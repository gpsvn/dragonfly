package com.inspireon.dragonfly.exception;

public class DragonFlyException extends Exception{
	private static final long serialVersionUID = 1L;

	public DragonFlyException(String message) {
		super(message);
	}
	
	public DragonFlyException() {
		super();
	}
}
