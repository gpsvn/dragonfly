package com.inspireon.dragonfly.application;

import com.inspireon.dragonfly.exception.ImageWrittenFailureException;
import com.inspireon.dragonfly.model.domain.image.ImageGroup;
import com.inspireon.dragonfly.web.rest.image.FileMeta;

public interface ImageGroupService {	
	
	ImageGroup uploadAvatarImage(FileMeta file) throws ImageWrittenFailureException;
	
	ImageGroup uploadFeaturedImage(FileMeta file) throws ImageWrittenFailureException;
	
	ImageGroup uploadContentImage(FileMeta file) throws ImageWrittenFailureException;
	
	void deleteImageGroup(ImageGroup imageGroup);	
	
	ImageGroup findImageGroup(String groupName);
}
