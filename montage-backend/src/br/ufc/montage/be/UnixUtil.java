package br.ufc.montage.be;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class UnixUtil {

	//public static final String home_dir = "/home/jefferson/TEMP/m101/";
	public static final String home_dir = "/home/jefferson/TEMP/pleiades/";
	
	public static synchronized String executeCommand(String command) {

		return "";
		/*
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

		
		return output.toString();*/

	}
	
	public static void executeBinBash(String cmd, String dir){
		File wd = new File(dir);
		System.out.println(wd);
		Process proc = null;
		try {
		   proc = Runtime.getRuntime().exec("/bin/bash", null, wd);
		}
		catch (IOException e) {
		   e.printStackTrace();
		}
		if (proc != null) {
		   BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		   PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(proc.getOutputStream())), true);
		   
		   out.println(cmd);
		   out.println("exit");
		   try {
		      String line;
		      while ((line = in.readLine()) != null) {
		         System.out.println(line);
		      }
		      proc.waitFor();
		      in.close();
		      out.close();
		      proc.destroy();
		   }
		   catch (Exception e) {
		      e.printStackTrace();
		   }
		}
	}
	
	public static void main(String[] args) {
		System.out.println("começou");
		//String cmd = "sh -c cd /home/jefferson/TEMP/pleiades/rawDir";
		//cmd +=" && ";
		/*String cmd ="/home/jefferson/TEMP/pleiades/rawDir/mArchiveList dss DSS2B 56.5 23.75 3 3 /home/jefferson/TEMP/pleiades/remote.tbl";
		System.out.println(cmd);
		System.out.println(UnixUtil.executeCommand(cmd));
		System.out.println("acabou");*/
		String dir = "/home/jefferson/TEMP/pleiades/rawDir";
		String cmd = "echo $JAVA_HOME >> teste.txt";		
		UnixUtil.executeBinBash(cmd,dir);
	}
}
