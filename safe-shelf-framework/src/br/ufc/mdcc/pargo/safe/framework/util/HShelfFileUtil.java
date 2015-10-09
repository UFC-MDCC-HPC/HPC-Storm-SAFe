package br.ufc.mdcc.pargo.safe.framework.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HShelfFileUtil {

	public static String readFileAsString(String fileLocation){
		File file = new File(fileLocation);
		String res = "";
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       res+=line;
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public static void saveStringIntoAFile(String content, String fileName){
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter( new FileWriter( fileName));
			writer.write( content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(writer!=null)
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	   
	}
	
	public static String readProperty(String value) {
		Properties prop = new Properties();
		InputStream input = null;
		String res = "";
		try {

			String filename = "safe.properties";
			input = HShelfFileUtil.class.getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				return "";
			}

			// load a properties file from class path, inside static method
			prop.load(input);

			// get the property value and print it out
			res = prop.getProperty(value);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return res;
	}
	
	
}
