package br.ufc.mdcc.pargo.safe.framework.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HShelfReflectionUtil {

	public static Object invokeMethod(Object o, String methodName,
			Object args[]) {
		Method allMethods[] = o.getClass().getDeclaredMethods();
		Object returnValue = null;
		for (Method method : allMethods) {
			String mName = method.getName();
			if (methodName.equals(mName)) {
				method.setAccessible(true);
				try {
					returnValue = method.invoke(o, args);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return returnValue;
	}

	public static void main(String[] args) {

		TestClass tc = new TestClass();
		String args2[] = { "Bom", "Dia" };
		Object res = HShelfReflectionUtil.invokeMethod(tc, "foo", args2);
		HShelfReflectionUtil.invokeMethod(tc, "foo2", args2);
		System.out.println(res);
		HShelfReflectionUtil.invokeMethod(tc, "foo3", null);
	}
}

class TestClass {

	public String foo(String arg1, String arg2) {
		return "Test: " + arg1 + "-" + arg2;
	}
	
	public void foo2(String arg1, String arg2){
		System.out.println("Test 2: " + arg1 + "-" + arg2);
	}
	
	public void foo3(){
		System.out.println("Sem parâmetros");
	}
}