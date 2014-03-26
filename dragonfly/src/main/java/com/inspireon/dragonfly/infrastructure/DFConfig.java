package com.inspireon.dragonfly.infrastructure;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.inspireon.dragonfly.common.util.ImageProperty;

public class DFConfig {
	private static final Logger logger = Logger.getLogger(DFConfig.class);
	private static String FILE_CONFIG = "dragonfly.properties";
	private static DFConfig dfConfig;
	private static Properties properties;			
	
	public static DFConfig getInstance() {
		if (dfConfig == null) {
			dfConfig = new DFConfig();
		}
		return dfConfig;
	}
	
	private DFConfig() {
		properties = new Properties();
		InputStream in = ImageProperty.class.getClassLoader().getResourceAsStream(FILE_CONFIG);
		try {
			properties.load(in);
			in.close();
		} catch (IOException e) {
			logger.error("Can not load property file: " + FILE_CONFIG, e);
		}
	}
	
	public String getAsString(String key) {
		String strValue = properties.getProperty(key);
		if (strValue == null) return StringUtils.EMPTY;
		return strValue.trim();
	}
	
	public long getAsLong(String key) {
		String strValue = getAsString(key);
		if (StringUtils.isEmpty(strValue)) return 0;
		return Long.valueOf(strValue.trim());
	}	
}
