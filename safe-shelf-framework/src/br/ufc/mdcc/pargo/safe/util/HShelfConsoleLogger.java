package br.ufc.mdcc.pargo.safe.util;

public class HShelfConsoleLogger {

	public static boolean ON = true;
	
	public static void write(String msg){
		if(HShelfConsoleLogger.ON) System.out.println("MSG: "+msg);
	}
}
