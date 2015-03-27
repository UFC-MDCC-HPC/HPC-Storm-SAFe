package br.ufc.mdcc.pargo.safe.port.conn;

import br.ufc.mdcc.pargo.safe.port.IHPCStormProvides;
import br.ufc.mdcc.pargo.safe.port.IHPCStormUses;

/**
 * This class \"connects\" two action methods. One from an uses port and another from a provides port.
 * @author jefferson
 *
 */
public class UsesProvidesConnection {

	private IHPCStormUses<?> uses;
	private IHPCStormProvides<?> provides;
	private String id;
	
	public UsesProvidesConnection(IHPCStormUses<?> uses, IHPCStormProvides<?> provides) {
		this.uses = uses;
		this.provides = provides;
		
		this.setId(uses, provides);
	}
	
	private void setId(IHPCStormUses<?> uses, IHPCStormProvides<?> provides){
		this.id = uses.getId()+"-"+provides.getId();
	}
	
	public String getId(){
		return this.id;
	}
	
	public void run(){
		//TODO
		 uses.action();
		 provides.action();
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof UsesProvidesConnection)) return false;
		
		UsesProvidesConnection ref = (UsesProvidesConnection)obj;
		if(!(ref.getId().equals(this.id)))return false;
		return true;
	}
}
