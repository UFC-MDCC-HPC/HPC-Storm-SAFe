package br.ufc.mdcc.pargo.safe.mobilecode.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class JarManipulator {

	public Class<?> createClass	(String pathToJar, String className){
		URLClassLoader child;
		Class<?> clazz = null;
		try {
			child = new URLClassLoader (
			        new URL[] {new URL(pathToJar)}, JarManipulator.class.getClassLoader());
			clazz = Class.forName(className, true, child);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return clazz;
	}
	
	public void invokeClassMethod(Class<?> clazz, String methodName){
		Method method;
		
		try {
			 
			Object messageObj = clazz.newInstance();
			method = clazz.getMethod(methodName);
			 
			method.invoke(messageObj);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
}
