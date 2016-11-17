package br.ufc.mdcc.pargo.safe.mobilecode.main;

import br.ufc.mdcc.pargo.safe.mobilecode.util.JarManipulator;

public class JarTest {

	public static void main(String[] args) {
		JarManipulator jarManipulator = new JarManipulator();
		Class<?> clazz = jarManipulator.createClass("file:/home/jefferson/jar-test.jar","br.ufc.FooClass");
		
		jarManipulator.invokeClassMethod(clazz, "method_1");
	}
}
