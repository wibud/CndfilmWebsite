package oa.util;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class ConfigurationUtil {
	
	public static Configuration readConfig(String filePath) throws ConfigurationException{
		return new PropertiesConfiguration(filePath);
	}
	
	
	public static void writeConfig(String filePath, String key, String value) throws ConfigurationException{
		PropertiesConfiguration config = (PropertiesConfiguration)readConfig(filePath);
		config.setProperty(key, value);
		config.save();
	}
}
