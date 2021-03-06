package com.inspireon.dragonfly.web.rest.image;

import java.io.Serializable;

import com.inspireon.dragonfly.common.util.ImageUtils;
import com.inspireon.dragonfly.model.domain.image.ImageGroup;

/**
 * View adapter for displaying information about Image
 * @author Cuong
 *
 */
public class ImageViewAdapter implements Serializable{

	private static final long serialVersionUID = 8579225858950462657L;
	
	private ImageGroup imageGroup;
	
	public ImageViewAdapter(ImageGroup imageGroup) {
		this.imageGroup = imageGroup;
	}

	public String getName() {
		return imageGroup.name();
	}

	public String getPath() {
		return imageGroup.path();
	}

	public String getType() {
		return imageGroup.type();
	}

	public String getOriginal() {
		return ImageUtils.getFullImageURL(imageGroup.original());
	}
	
	public String getSmall() {
		return ImageUtils.getFullImageURL(imageGroup.small());
	}

	public String getLarge() {
		return ImageUtils.getFullImageURL(imageGroup.large());
	}		
	
	public String getFull() {
		return ImageUtils.getFullImageURL(imageGroup.full());
	}		
}
