package br.ufc.mdcc.pargo.safe.expert.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FileUtil {
	
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

	public static String readProperty(String value) {
		Properties prop = new Properties();
		InputStream input = null;
		String res = "";
		try {

			String filename = "safe-expert.properties";
			input = FileUtil.class.getClassLoader().getResourceAsStream(filename);
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
	
	public static List<String> listFiles(String dir){
		List<String> results = new ArrayList<String>();


		File[] files = new File(dir).listFiles();
		//If this pathname does not denote a directory, then listFiles() returns null. 

		for (File file : files) {
		    if (file.isFile()) {
		        results.add(file.getName());
		    }
		}
		
		return results;
	}
}
