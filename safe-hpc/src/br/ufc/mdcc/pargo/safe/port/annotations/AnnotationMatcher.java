package br.ufc.mdcc.pargo.safe.port.annotations;

import java.lang.reflect.Method;

import br.ufc.mdcc.pargo.safe.factory.HPCStormConnectorServicesFactory;
import br.ufc.mdcc.pargo.safe.port.IHPCStormPort;
import br.ufc.mdcc.pargo.safe.services.IHPCStormConnectorService;

public class AnnotationMatcher {
	
	private IHPCStormConnectorService connService = HPCStormConnectorServicesFactory.getHPCStormConnectorService();

	public void match(IHPCStormPort portA, IHPCStormPort portB) {
		
		Method[] methodsA = portA.getClass().getMethods();
		Method[] methodsB = portB.getClass().getMethods();
		for (Method methodA : methodsA) {
			
			//returns null in case the method has not the desired annotation
			UsesProvidesAnnotation upA = methodA
					.getAnnotation(UsesProvidesAnnotation.class);
			
			//this method has the desire annotation in App
			if (upA != null) {
				//now, we look into workflow pre-def-port
				for(Method methodB:methodsB){
					UsesProvidesAnnotation upB = methodB
							.getAnnotation(UsesProvidesAnnotation.class);
					if(upB != null){
						
						//now, compare keys and connect methods...
						if(upA.key()==upB.key()){
							//found!
							MethodUsesProvidesConnection mupc;
							if(portA.getType().equals(IHPCStormPort.uses)){
								connService.connect(portA, methodA, portB, methodB);
								
							}else{
							    connService.connect(portB, methodB,portA, methodA);
								
							}
							
							return;
						}//if keys
					}//if upB
				}//for intern
			}//if upA
		}//for external
	}

	
	 

}
