package com.inspireon.dragonfly.common.util;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.inspireon.dragonfly.infrastructure.DFConfig;
import com.inspireon.dragonfly.model.domain.image.Size;

public class ImageProperty {
	private static final Logger logger = Logger.getLogger(ImageProperty.class);
	public static final String IMAGE_GROUP_NAME_SEPARATOR = "_";
	
	public static final String IMAGE_ROOT = DFConfig.getInstance().getAsString("image.root");
	public static final String IMAGE_HOST_SERVICE = DFConfig.getInstance().getAsString("image.host.service");
	public static final String DEFAULT_IMAGE_AVATAR_PATH = DFConfig.getInstance().getAsString("image.default.avatar.path");
	public static final String DEFAULT_IMAGE_FEATURED_PATH = DFConfig.getInstance().getAsString("image.default.featured.path");
	
	public static final String IMAGE_NAME_ORIGINAL = DFConfig.getInstance().getAsString("image.name.original");
	public static final String IMAGE_NAME_FULL = DFConfig.getInstance().getAsString("image.name.full");
	public static final String IMAGE_NAME_SMALL = DFConfig.getInstance().getAsString("image.name.small");
	//public static final String IMAGE_NAME_MEDIUM = DFConfig.getInstance().getAsString("image.name.medium");
	public static final String IMAGE_NAME_LARGE = DFConfig.getInstance().getAsString("image.name.large");
			
	public static final Size AVATAR_SMALL = stringToSize(DFConfig.getInstance().getAsString("image.size.avatar.small"));
	public static final Size AVATAR_LARGE = stringToSize(DFConfig.getInstance().getAsString("image.size.avatar.large"));
	public static final Size FEATURED_SMALL = stringToSize(DFConfig.getInstance().getAsString("image.size.featured.small"));
	public static final Size FEATURED_LARGE = stringToSize(DFConfig.getInstance().getAsString("image.size.featured.large"));
	
	public static final Size FULL = stringToSize(DFConfig.getInstance().getAsString("image.size.full"));
	public static final long SIZE_MAXIMUM = DFConfig.getInstance().getAsLong("image.size.maximum");
	
	private static Size stringToSize(String sizeStr) {
		if (StringUtils.isEmpty(sizeStr)) {
			logger.error("Must have all image configuration in property file(small|large)!");
			throw new NullPointerException();
		}
		String[] toks = sizeStr.split("x");
		return new Size(Integer.valueOf(toks[0]), Integer.valueOf(toks[1]));
	}		
}
