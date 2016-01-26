package br.ufc.montage.be;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UnixUtil {

	public static final String home_dir = "/home/jefferson/TEMP/m101/";
	
	public static synchronized String executeCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = 
                            new BufferedReader(new InputStreamReader(p.getInputStream()));

                        String line = "";			
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return output.toString();

	}
	
	public static void main(String[] args) {
		System.out.println("começou");
		System.out.println(UnixUtil.executeCommand("ps -aux"));
		System.out.println("acabou");
	}
}
