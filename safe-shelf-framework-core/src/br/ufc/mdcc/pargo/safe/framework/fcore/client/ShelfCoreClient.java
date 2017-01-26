package br.ufc.mdcc.pargo.safe.framework.fcore.client;

import br.ufc.mdcc.pargo.safe.framework.fcore.stub.IShelfCore;
import br.ufc.mdcc.pargo.safe.framework.fcore.stub.ShelfCoreImplService;

public class ShelfCoreClient{

	private ShelfCoreImplService coreService;
	private IShelfCore corePort;
	
	public ShelfCoreClient() {
		this.coreService = new ShelfCoreImplService();
		this.corePort = this.coreService.getShelfCoreImplPort();
	}
	
	
	public String resolve(String contract) {
		return this.corePort.resolve(contract);
	}

	
	public String deploy(String safeSWLCode, String componentReference) {
		return this.corePort.deploy(safeSWLCode, componentReference);
	}

	
	public String instantiate(String wsession, String reference) {
		return this.corePort.instantiate(wsession, reference);
	}

	
	public void release(String ID) {
		this.corePort.release(ID);
		
	}

	
	public String listParameter(String contract) {
		return this.corePort.listParameter(contract);
	}

	
	public void setComponentList(String componentList) {
		this.setComponentList(componentList);
		
	}

}
