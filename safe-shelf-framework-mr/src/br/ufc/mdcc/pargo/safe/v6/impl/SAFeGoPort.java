package br.ufc.mdcc.pargo.safe.v6.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.ufc.mdcc.pargo.safe.v6.ISAFeComponent;
import br.ufc.mdcc.pargo.safe.v6.ISAFeGoPort;

public class SAFeGoPort extends SAFePort implements ISAFeGoPort{

	 

	public SAFeGoPort(ISAFeComponent parent, String id) {
		super(parent, id);
	}

	@Override
	public int go() {
		if(this.getParent()!=null){
			try {
				Method m = this.getParent().getClass().getMethod("go");
				m.invoke(this.getParent());
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
			}
		}
		return 0;
	}

}
