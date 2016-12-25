package launcher;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class STproperties {

	public STproperties() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		readySeeTest();

	}

	/**
	 * @throws IOException
	 */
	public static void readySeeTest() throws IOException {
		Properties prop = new Properties();

		String cloudIP = "192.168.1.210";
		int cloudPort = 80;
		String cloudUser = "eyal";
		String encPassword = "2F7A6F3176536C663675306E6556312F31514D7455673D3D";
		
		
		//String appdatapath = "C:\\Users\\eyal.neumann\\AppData\\Roaming";
		String appdatapath=System.getenv("Appdata");
		
		
		
		
		String seetestAppDataPath = appdatapath+"\\seetest";
		File sPFile =new File (seetestAppDataPath);
		if (sPFile.exists()){
			System.out.println("SeeTest AppData folder exist");
		}
		else{
			System.out.println("SeeTest AppData Folder dont exist");
			System.out.println("Creating SeeTest AppData Folder");
			sPFile.mkdirs();
		}

		
		String appPropertyPath = appdatapath+"\\seetest\\app.properties";
		System.out.println("app.property file should be at : "+appPropertyPath);
		File pFile =new File (appPropertyPath);
		if (pFile.exists()){
			System.out.println("app.property file is at : "+appPropertyPath);

		}else{
			System.out.println("app.property file is not at : "+appPropertyPath);
			boolean isExist= pFile.createNewFile();
			System.out.println("createNewFile returns : "+isExist);
		}
		
		try (InputStream input = new FileInputStream(appPropertyPath);){
			prop.load(input);
			try (OutputStream output  = new FileOutputStream(appPropertyPath);){
				
				prop.setProperty("use.floating.licens", "true");
				prop.setProperty("license.type", "sentinel");
				prop.setProperty("remote.license.manager", "192.168.1.205");
				prop.setProperty("license.type", "sentinel");

				prop.setProperty("floating.defaults", "ANDROID,IPHONE,DEVELOPER_MACHINE,");
				prop.setProperty("first.launch", "false");
				prop.setProperty("suspend.floating.dialog", "true");

				prop.setProperty("cloudserver.available.list", cloudIP+":"+cloudPort);
				prop.setProperty("cloudserver.list", cloudIP+":"+cloudPort+":"+cloudUser+":"+encPassword+":true:false:");
				prop.setProperty("block.cloud.server.access", "false");
				
		
				
				prop.store(output,null);
			}
				
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
