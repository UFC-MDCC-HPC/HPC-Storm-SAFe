package br.ufc.mdcc.pargo.safe.framework.port;

import java.util.ArrayList;
import java.util.List;

import br.ufc.mdcc.pargo.safe.framework.util.HShelfConsoleLogger;

public class HShelfActionPort extends HShelfPort{

	private List<HShelfActionPort> partners;
	
	public HShelfActionPort() {
		this.partners = new ArrayList<HShelfActionPort>();
	}
	
	public void invoke(Object action){
		/*if(action.toString().equals("perform")){
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		HShelfConsoleLogger.write(action.toString());
	}
	
	public void invoke(Object action, IHShelfActionFuture actionFuture){
		HShelfConsoleLogger.write(action.toString());
	}
	
	
}
