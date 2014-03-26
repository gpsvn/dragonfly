package com.inspireon.dragonfly.persistence;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inspireon.dragonfly.model.domain.device.Device;
import com.inspireon.dragonfly.model.domain.device.DeviceRepo;
import com.inspireon.dragonfly.model.domain.user.User;
import com.inspireon.dragonfly.model.domain.user.UserRepo;
import com.inspireon.dragonfly.model.domain.vehicle.VehicleRecord;
import com.inspireon.dragonfly.model.domain.vehicle.VehicleRecordRepo;
import com.inspireon.dragonfly.model.manager.UserManager;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/test-context.xml"})
public class UserRepoTest {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private VehicleRecordRepo vehicleRepo;
	
	@Autowired
	private DeviceRepo deviceRepo;
	
	@Autowired
	private UserManager userManager;

	@Ignore
	@Test
	public void findLatestTest(){
		VehicleRecord vr = vehicleRepo.findLatest();
		System.out.println(vr.getTimestamp());
		System.out.println(vr.getDirection());
		System.out.println(vr.getSpeed());
		System.out.println(vr.getSim());
	}
	
	@Ignore
	@Test
	public void addUserTest(){
		User us = new User("huonglua", new BCryptPasswordEncoder().encode("123456"), "huonglua@huongratlua.com");
		userRepo.add(us);
	}
	
	
	@Test
	public void addDevices(){
		Device device = new Device("TG102", 
				"1642756747", "XX-XXXX", "Huyndai", "huonglua", "", "Xe Khach", "admin");
		Device device1 = new Device("TG102", 
				"0000000000", "11-1111", "Huyndai", "huonglua", "", "Xe Khach", "admin");
		Device device2 = new Device("TG102", 
				"0000000000", "22-2222", "Huyndai", "huonglua", "", "Xe Khach", "admin");
		Device device3 = new Device("TG102", 
				"0000000000", "33-3333", "Huyndai", "huonglua", "", "Xe Khach", "admin");
		deviceRepo.add(device);
		deviceRepo.add(device1);
		deviceRepo.add(device2);
		deviceRepo.add(device3);
	}
	
}
