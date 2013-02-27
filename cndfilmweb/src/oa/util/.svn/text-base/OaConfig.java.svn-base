package oa.util;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;

import oa.exception.LocalException;

public class OaConfig {
	public static final Configuration config = getConfig("oa.properties");
	
	public static final boolean devMode = getBoolean("oa.devMode", false);

	static {
		if(devMode){
			System.out.println("===================   starting in develope mode   ===================");
		}else{
			System.out.println("===================   starting in deploy mode   ===================");
		}
	}
	
	private static Configuration getConfig(String fileName){
		try {
			return ConfigurationUtil.readConfig(fileName);
		} catch (ConfigurationException e) {
			ExceptionUtil.handleException(new LocalException(e));
			return null;
		}
	}
	
	private static boolean getBoolean(String key, boolean defaultVal){
		if(config == null){
			return defaultVal;
		}
		try {
			return config.getBoolean(key);
		} catch (Exception e) {
			ExceptionUtil.handleException(new LocalException(e));
			return defaultVal;
		}
	}
	
	private static String getString(String key, String defaultVal){
		if(config == null){
			return defaultVal;
		}
		try {
			return config.getString(key);
		} catch (Exception e) {
			ExceptionUtil.handleException(new LocalException(e));
			return defaultVal;
		}
	}
}
