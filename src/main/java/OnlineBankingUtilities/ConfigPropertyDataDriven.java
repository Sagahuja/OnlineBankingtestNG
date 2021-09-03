package OnlineBankingUtilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertyDataDriven {

	
	String ConfigPropPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "Resources" + File.separator + "Config.properties";
	
	//user.dir + "//src//main//java/configproperties"
	public String getProperty(String systemproperty) throws IOException {
		Properties propertiesobj = new Properties();
		FileReader fileobj = new FileReader(ConfigPropPath);
		propertiesobj.load(fileobj);
		return propertiesobj.getProperty(systemproperty);
	}
}
