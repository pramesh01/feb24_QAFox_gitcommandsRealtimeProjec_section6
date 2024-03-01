package util;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReader {

	public static Properties initializePropertyfile() {
		
		Properties prop=new Properties();
		try {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//config//config.properties");
		prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return prop;
		
	}
}
