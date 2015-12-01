package br.ufc.m101.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class M101Properties {

	public static String readProperty(String value) {
		Properties prop = new Properties();
		InputStream input = null;
		String res = "";
		try {

			String filename = "config.properties";
			input = M101Properties.class.getClassLoader().getResourceAsStream(filename);
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
