package br.ufc.mdcc.pargo.safe.framework.port;

public class HShelfTaskPort extends HShelfPort{

	private HShelfTaskPort partner;
	
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
