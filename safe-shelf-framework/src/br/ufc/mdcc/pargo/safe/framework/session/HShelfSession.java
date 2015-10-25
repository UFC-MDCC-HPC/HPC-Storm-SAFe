package br.ufc.mdcc.pargo.safe.framework.session;

import java.util.HashMap;
import java.util.Map;

public class HShelfSession {

	private static Map<String, String> session =
			new HashMap<String, String>();
	
	public static void putValue(String key,String value){
		session.put(key, value);
	}
	
	public static String getValue(String key){
		return session.get(key);
	}
}
