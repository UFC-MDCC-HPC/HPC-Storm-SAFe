package br.ufc.mdcc.pargo.safe.mobilecode.proxy;

import br.ufc.mdcc.pargo.safe.mobilecode.util.JarManipulator;

public class ProxyClass<T> {

	private String jarLocation = "file:/home/jefferson/jar-test.jar";
	
	public void invoke(String method, Object... args){
		
		JarManipulator jarManipulator = new JarManipulator();
		//Class<?> clazz = jarManipulator.createClass(jarLocation,c.getClass().getCanonicalName());
	}
}
