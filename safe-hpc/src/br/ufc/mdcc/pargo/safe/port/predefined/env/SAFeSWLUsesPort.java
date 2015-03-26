package br.ufc.mdcc.pargo.safe.port.predefined.env;

import br.ufc.mdcc.pargo.safe.component.IHPCStormComponent;
import br.ufc.mdcc.pargo.safe.framework.HPCStormSAFeSWL;
import br.ufc.mdcc.pargo.safe.framework.IHPCStormWorkflowComponent;
import br.ufc.mdcc.pargo.safe.port.HPCStormEnvPortUses;
import br.ufc.mdcc.pargo.safe.util.SAFeConsoleLogger;

public class SAFeSWLUsesPort<In> extends HPCStormEnvPortUses<In>{

	private String name;
	private boolean conn;
	private String id;
	private In data;
	private IHPCStormComponent parent;
	
	public SAFeSWLUsesPort(Class<In> type) {
		super(type);
		this.name = "safeswl-uses";
		this.id = "swl-u-id";
	}

	public String getId(){
		return this.id;
	}
	
	@Override
	public Class<In> getType() {
		return this.type;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		//IN THIS CASE, YOU HAVE TO PUT data INTO parent
		SAFeConsoleLogger.write("Calling pre-def uses port for safeswl...");
		HPCStormSAFeSWL swl = (HPCStormSAFeSWL)data;
		((IHPCStormWorkflowComponent)this.parent).setSAFeSWL(swl);
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
	public void setIn(In in) {
		this.data = in;
	}

	@Override
	public void setComponent(IHPCStormComponent parent) {
		this.parent = parent;
	}
	
}