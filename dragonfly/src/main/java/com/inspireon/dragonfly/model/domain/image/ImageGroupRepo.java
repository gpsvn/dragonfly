package com.inspireon.dragonfly.model.domain.image;

import com.inspireon.dragonfly.persistence.BaseRepo;

public interface ImageGroupRepo extends BaseRepo<ImageGroup, String> {
	
	ImageGroup findByFileName(String fileName);	
}
