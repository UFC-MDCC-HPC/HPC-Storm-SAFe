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
	
	
	public Object openWorkflowSession(String safeSWLCode){
		return this.corePort.openWorkflowSession(safeSWLCode);
	}
	
	public void registerContract(String contract){
		this.corePort.registerContract(contract);
	}
	
	public void closeWorkflowSession(String session){
		this.corePort.closeWorkflowSession(session);
	}
	
	public String resolve(String contract) {
		return this.corePort.resolve(contract);
	}

	
	public String deploy(String wsession, String componentReference) {
		return this.corePort.deploy(wsession, componentReference);
	}

	
	public String instantiate(String wsession, String componentReference) {
		return this.corePort.instantiate(wsession, componentReference);
	}

	
	public void release(String ID) {
		this.corePort.release(ID);
		
	}

	
	public String listParameter(String contract) {
		return this.corePort.listParameter(contract);
	}

	
	public void setComponentList(String componentList) {
		this.corePort.setComponentList(componentList);
		
	}

}
