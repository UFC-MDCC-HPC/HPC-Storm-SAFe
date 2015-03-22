package br.ufc.mdcc.pargo.safe.port.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.ufc.mdcc.pargo.safe.port.IHPCStormPort;

/**
 * This class \"connects\" two methods. One from an uses port and another from a provides port.
 * @author jefferson
 *
 */
public class MethodUsesProvidesConnection {

	private IHPCStormPort uses;
	private IHPCStormPort provides;
	private Method usesMethod, providesMethod;
	
	public MethodUsesProvidesConnection(IHPCStormPort uses, Method usesMethod,  
			IHPCStormPort provides, Method provideMethod) {
		this.uses = uses;
		this.provides = provides;
		this.usesMethod = usesMethod;
		this.providesMethod = provideMethod;
	}
	
	public void run(){
		try {
			this.usesMethod.invoke(this.uses);
			this.providesMethod.invoke(this.provides);
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
