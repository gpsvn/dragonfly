package com.inspireon.dragonfly.web.rest.record;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inspireon.dragonfly.model.domain.vehicle.VehicleRecord;
import com.inspireon.dragonfly.model.domain.vehicle.VehicleRecordRepo;
import com.inspireon.dragonfly.web.rest.base.AbstractBaseController;

@Controller
public class RecordController extends AbstractBaseController{

	private static final Logger logger = Logger.getLogger(RecordController.class);
	
	@Autowired
	private VehicleRecordRepo recordRepo;
	
	@RequestMapping(value="/record/load", method = RequestMethod.GET)
	public @ResponseBody 
	Response loadRecords(){
		VehicleRecord vr = recordRepo.findLatest();
		RecordViewAdapter view = new RecordViewAdapter(vr);
		return success(view);
	}
}
