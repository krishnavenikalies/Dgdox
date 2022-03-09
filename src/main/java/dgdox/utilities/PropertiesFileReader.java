package dgdox.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

	public static Properties getData(String appName) {
	Properties prop = new Properties();
	File propertyFile = new File(System.getProperty("user.dir")+"\\Resources\\config.properties");
	FileInputStream fileInput = null;
	//System.out.println("propertyFile############"+propertyFile);
	try {
		fileInput = new FileInputStream(propertyFile);
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
	try {
		prop.load(fileInput);
		System.out.println("Properties File Loadded successfully : "
				+ appName);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return prop;
	
	}
}
