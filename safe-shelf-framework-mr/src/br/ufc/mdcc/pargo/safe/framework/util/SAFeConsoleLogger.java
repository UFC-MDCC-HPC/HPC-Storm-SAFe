package br.ufc.mdcc.pargo.safe.framework.util;

public class SAFeConsoleLogger {

	public static boolean ON = true;
	
	public static void write(String msg){
		if(SAFeConsoleLogger.ON) System.out.println("MSG: "+msg);
	}
}
