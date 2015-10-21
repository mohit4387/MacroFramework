package framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFile
{
	public static String getValue (String key) throws IOException
	{
		String value = null;
		//configfile path can be defined in a better way
		File file = new File ("D:\\macroframework\\src\\test\\java\\framework\\config.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
		
		Properties properties = new Properties();
		try {
			properties.load(fileInput);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
				
		value = properties.getProperty(key);
		fileInput.close();
		return value;
	}

}
