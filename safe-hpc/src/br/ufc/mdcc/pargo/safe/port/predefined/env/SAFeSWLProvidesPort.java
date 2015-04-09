package br.ufc.mdcc.pargo.safe.port.predefined.env;

import br.ufc.mdcc.pargo.safe.application.HPCStormApplicationFramework;
import br.ufc.mdcc.pargo.safe.component.IHPCStormComponent;
import br.ufc.mdcc.pargo.safe.framework.HPCStormSAFeSWL;
import br.ufc.mdcc.pargo.safe.port.HPCStormEnvPortProvides;
import br.ufc.mdcc.pargo.safe.util.SAFeConsoleLogger;




public class SAFeSWLProvidesPort<Out> extends HPCStormEnvPortProvides<Out>{

	
	private String name;
	private boolean conn;
	private String id;
	private Out data;
	private IHPCStormComponent parent;
	
	public SAFeSWLProvidesPort(Class<Out> type) {
		super(type);
		this.name = "safeswl-provides";
		this.id = "swl-p-id";
	}
	
	public String getId(){
		return this.id;
	}
	
	@Override
	public Class<Out> getType() {
		return this.type;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void action() {
		// TODO Auto-generated method stub
		//CALL COMPONENT PARENT METHOD THAT FEED data (a lot of casts)
		SAFeConsoleLogger.write("Calling pre-def provides port for safeswl..."+this.type);
		HPCStormSAFeSWL safeSWL = ((HPCStormApplicationFramework)this.parent).createSAFeSWL();
		this.data = (Out)safeSWL;
	}

	@Override
	public boolean isConnected() {
		return this.conn;
	}

	@Override
	public void setConnected(boolean value) {
		this.conn = value;
	}

	@Override
	public Out getOut() {
		return data;
	}

	@Override
	public void setComponent(IHPCStormComponent parent) {
		this.parent = parent;
		
	}
	
	
}
