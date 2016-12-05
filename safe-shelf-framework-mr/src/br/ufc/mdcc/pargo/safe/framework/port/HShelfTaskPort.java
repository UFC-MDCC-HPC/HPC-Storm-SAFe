package br.ufc.mdcc.pargo.safe.framework.port;

import br.ufc.mdcc.pargo.safe.framework.util.HShelfConsoleLogger;

public class HShelfTaskPort extends HShelfPort{

	private HShelfTaskPort partner;
	
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
	
	public boolean isConnected(){
		if(partner==null) return false;
		return true;
	}

	public HShelfTaskPort getPartner() {
		return partner;
	}

	public void setPartner(HShelfTaskPort partner) {
		this.partner = partner;
	}
}
