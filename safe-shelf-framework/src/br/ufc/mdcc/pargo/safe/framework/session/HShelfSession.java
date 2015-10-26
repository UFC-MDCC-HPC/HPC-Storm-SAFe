package br.ufc.mdcc.pargo.safe.framework.session;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is shared between all objects in SAFe. It works like a session, in web programming.
 * 1-) Share wsdl port location between workflow object and proxy ports. The name of the port is the key;
 * @author jefferson
 *
 */
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
