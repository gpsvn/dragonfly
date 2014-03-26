package com.inspireon.dragonfly.web.rest.home;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.inspireon.dragonfly.model.domain.device.Device;
import com.inspireon.dragonfly.model.domain.device.DeviceRepo;
import com.inspireon.dragonfly.web.rest.base.AbstractBaseController;
import com.inspireon.dragonfly.web.rest.security.MystoryUserReference;
import com.inspireon.dragonfly.web.rest.shared.context.MystoryUser;

@Controller
public class HomeController extends AbstractBaseController {
	
	private static final Logger logger = Logger.getLogger(HomeController.class);
	
	@Autowired
	private DeviceRepo deviceRepo;

	@RequestMapping("/home")
	public ModelAndView defaultPage() {
		MystoryUser user = MystoryUserReference.getLoggedInUser();
		if(user==null) return new ModelAndView("accessdenied");
		else{
			
			List<Device> devices = deviceRepo.findByUser(user.getUsername());
			
			//Create device map, key is device type, value is a list of car model.
			Map<String, List<Device>> deviceMap = new HashMap<String, List<Device>>();
			
			for(Device device : devices){
				if(!deviceMap.containsKey(device.getDeviceType())){
					deviceMap.put(device.getDeviceType(), this.findAllDevices(device.getDeviceType(), devices));
					logger.info("Device >>> " + device.toString());
					logger.info("Device Map >>> " + deviceMap);
				}
			}
			
			return new ModelAndView("home", "deviceMap", deviceMap);
		}
	}
	
	/**
	 * Find a list of device by device type.
	 * @param deviceType the device type
	 * @param devices a list of devices.
	 * @return a list of device by device type.
	 */
	private List<Device> findAllDevices(String deviceType, List<Device> devices){
		List<Device> ostDevices = new ArrayList<Device>();
		
		for(Device device : devices){
			if(deviceType.equalsIgnoreCase(device.getDeviceType())){
				ostDevices.add(device);
			}
		}
		return ostDevices;
	}
	  
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginPage() {
		
		if(MystoryUserReference.getLoggedInUser() != null){
			return "redirect:/home";
		}
		
		return "login";
	}
	
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String registerPage() {
		
		return "register";
	}
	
	@RequestMapping(value="/resetpassword", method = RequestMethod.GET)
	public String resetPassword() {
		
		return "resetPassword";
	}

	@RequestMapping(value="/accessdenied", method = RequestMethod.GET)
	public String accessDenied() {
		
		return "accessDenied";
	}
	
	@RequestMapping(value="/notfound", method = RequestMethod.GET)
	public String notFound() {
		return "notfound";
	}
}
