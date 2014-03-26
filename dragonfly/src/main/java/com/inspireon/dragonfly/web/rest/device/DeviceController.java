package com.inspireon.dragonfly.web.rest.device;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.inspireon.dragonfly.model.domain.device.Device;
import com.inspireon.dragonfly.model.domain.device.DeviceRepo;
import com.inspireon.dragonfly.model.domain.vehicle.VehicleRecord;
import com.inspireon.dragonfly.model.domain.vehicle.VehicleRecordRepo;
import com.inspireon.dragonfly.web.rest.base.AbstractBaseController;
import com.inspireon.dragonfly.web.rest.security.MystoryUserReference;
import com.inspireon.dragonfly.web.rest.shared.context.MystoryUser;

@Controller
public class DeviceController extends AbstractBaseController{

	private static final Logger logger = Logger.getLogger(DeviceController.class);

	@Autowired
	private DeviceRepo deviceRepo;
	
	@Autowired
	private VehicleRecordRepo recordRepo;
	
	@RequestMapping(value="/device/add", method = RequestMethod.GET)
	public ModelAndView add(@ModelAttribute DeviceCommand command){
		MystoryUser user = MystoryUserReference.getLoggedInUser();
		if(user==null) return new ModelAndView("permission denied");
		else{
			
			Device device = new Device(command.getDeviceType(), 
					command.getSim(), command.getPlateNumber(), command.getCarModel(),
					command.getCustomer(), 
					command.getVIN(), command.getNote(), user.getUsername());
			
			deviceRepo.add(device);
			
			return new ModelAndView("");
		}
	}
	
	@RequestMapping(value="/device/list/", method = RequestMethod.GET)
	public ModelAndView list(@ModelAttribute DeviceCommand command){
		MystoryUser user = MystoryUserReference.getLoggedInUser();
		if(user==null) return new ModelAndView("accessdenied");
		else{
			
			List<Device> devices = deviceRepo.findByUser(user.getUsername());
			List<DeviceAdapter> adapters = new ArrayList<DeviceAdapter>();
			for(Device device : devices){
				adapters.add(new DeviceAdapter(device));
			}
			return new ModelAndView("home", "devices", adapters);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/device/live")
	public @ResponseBody List<DeviceLive> live(){
		MystoryUser user = MystoryUserReference.getLoggedInUser();
		if(user==null) return null;
		else{
			
			List<Device> devices = deviceRepo.findByUser(user.getUsername());
			List<DeviceLive> deviceLive = new ArrayList<DeviceLive>();
			for(Device device : devices){
				VehicleRecord record = recordRepo.findLatestById(device.getSim());
				if(record != null)
					deviceLive.add(new DeviceLive(device, record));
				/*else
					deviceLive.add(new DeviceLive(device, new VehicleRecord()));*/
			}
			return deviceLive;
		}
	}
}
