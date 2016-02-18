package br.ufc.mdcc.pargo.safe.grammar.test;

import br.ufc.mdcc.pargo.safe.framework.util.HShelfReflectionUtil;

public class TestInvoke {

	public static void main(String[] args) {
		TestClass tc = new TestClass();
		
		Object o = HShelfReflectionUtil.invokeMethod(tc, "go", null);
		System.out.println(o.getClass());
	}
}

class TestClass{
	
	public boolean go(){
		return true;
	}
}