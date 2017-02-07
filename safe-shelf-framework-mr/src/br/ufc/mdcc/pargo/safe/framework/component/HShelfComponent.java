package br.ufc.mdcc.pargo.safe.framework.component;

import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfSelectionPort;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.port.dflt.HShelfWorkflowServicesProvidesPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.framework.util.HShelfConsoleLogger;
import br.ufc.mdcc.pargo.safe.grammar.arch.SAFeOrquestrationArchitecture;
import br.ufc.mdcc.pargo.safe.grammar.util.FileUtil;

public abstract class HShelfComponent {

	private String name;
	private String contractPath;
	private String kind;
	private String safeSWLPath;
	private Object parameterList;
	private Object valorationSet;
	private boolean isDeployActivated = false; 
	private boolean isInstantiateActivated = false;
	
	
	
	private HShelfUsesPort workflowServicesUsesPort;
	protected IHShelfService services;
	
	
	public abstract void setServices(IHShelfService services);

	

	public void resolve(){
		HShelfConsoleLogger.write("Calling RESOLVE from :"+this.getName()+", KIND: " + this.getKind());
		String contractContent = FileUtil.readFileAsString(contractPath); //CONTEÚDO DO CONTRATO CONTEXTUAL DESSE COMPONENTE
		
		try {
			if(this.workflowServicesUsesPort==null)
				this.workflowServicesUsesPort = (HShelfUsesPort) this.services.getPort(this.getWorkflowServicesPortName());
		} catch (HShelfException e1) {
			 
			e1.printStackTrace();
		}
		

		try {
			HShelfWorkflowServicesProvidesPort providesPort = (HShelfWorkflowServicesProvidesPort)this.services.getConnectedProvidesPort(this.workflowServicesUsesPort.getName());
			/*B -1 : CHAMADA DO MÉTODO RESOLVE, PASSANDO O CONTEÚDO DO CONTRATO DESSE STUB*/
			providesPort.resolve(contractContent);
			
			/*2 - RECEBE A LISTA DE PARÂMETROS QUE GORVENAM A ORDENAÇÃO DA LISTA DE COMPONENTES*/
			this.parameterList = providesPort.listParameter(contractContent);
		} catch (HShelfException e1) {
			 
			e1.printStackTrace();
		}
		
		
		
		try {
			HShelfUsesPort usesSelectionPort = (HShelfUsesPort) this.services.getPort(this.getSelectionPortName());
			HShelfSelectionPort selectionPort = (HShelfSelectionPort)this.services.getConnectedProvidesPort(usesSelectionPort.getName());
		    /*3 - REPASSA PARA A APLICAÇÃO A LISTA DE PARÂMETROS RECEBIDA EM 2*/
			/*4 - RECEBE COMO RETORNO UM CONJUNTO DE VALORAÇÕES*/
			this.valorationSet = selectionPort.selection(this.parameterList);
			
			/*5 - ATUALIZA, PARA O CORE, A LISTA ORDENADA DE COMPONENTES PASSANDO O VALORATION SET*/
			HShelfWorkflowServicesProvidesPort providesPort = (HShelfWorkflowServicesProvidesPort)this.services.getConnectedProvidesPort(this.workflowServicesUsesPort.getName());
			//providesPort.setComponentList(this.valorationSet);
			providesPort.setComponentList(this.valorationSet.toString()); //TODO AJEITAR
			
		} catch (HShelfException e) {
			
			e.printStackTrace();
		}
		
		
		
		this.isDeployActivated = true;  
	}
	
	public void deploy(){
		if(isDeployActivated){
			
			try {
				if(this.workflowServicesUsesPort==null)
					this.workflowServicesUsesPort = (HShelfUsesPort) this.services.getPort(this.getWorkflowServicesPortName());
				
			} catch (HShelfException e1) {
				e1.printStackTrace();
			}
			
			HShelfConsoleLogger.write("Calling DEPLOY from :"+this.getName()+", KIND: " + this.getKind());
			
			HShelfWorkflowServicesProvidesPort providesWorkflowPort = null;
			try {
				providesWorkflowPort = (HShelfWorkflowServicesProvidesPort)this.services.getConnectedProvidesPort(this.workflowServicesUsesPort.getName());
			} catch (HShelfException e) {
				
				e.printStackTrace();
			}
			
			if(this.kind.equals(SAFeOrquestrationArchitecture.PLATFORM)){
				/*C-1 : CHAMANDO O DEPLOY PASSANDO O WORKFLOW_SESSION E A REFERENCIA DESTE COMPONENTE*/
				/*APENAS SE FOR DO TIPO PLATAFORMA*/
				providesWorkflowPort.deploy(null, null);
				
			}else{
				
			}
			
			/*for(Object candidate:this.permuted){
				String safeSWLCode = FileUtil.readFileAsString(safeSWLPath);
				if(this.kind.equals(SAFeOrquestrationArchitecture.PLATFORM)){
					
					this.backEndAdress = providesWorkflowPort.deploy(safeSWLCode,this.getName(),candidate); 
					
					if(this.backEndAdress!=null){
						XMLManipulator.changeComponentAddressAtt(safeSWLPath, this.name, this.backEndAdress);
						isInstantiateActivated = true;
						selectedCandidate = candidate;
						break;
					}
				}else if(this.kind.equals(SAFeOrquestrationArchitecture.COMPUTATION) ||
						this.kind.equals(SAFeOrquestrationArchitecture.CONNECTOR)) {
						providesWorkflowPort.deploy(safeSWLCode,this.getName(),candidate);
						isInstantiateActivated = true;
						selectedCandidate = candidate;
						break;
				}
				
			}*/
		}
		
		isInstantiateActivated = true;

	}
	
	public void instantiate(){
		HShelfWorkflowServicesProvidesPort providesWorkflowPort = null;
		if(isInstantiateActivated){
			
			try {
				if(this.workflowServicesUsesPort==null)
					this.workflowServicesUsesPort = (HShelfUsesPort) this.services.getPort(this.getWorkflowServicesPortName());
				providesWorkflowPort = (HShelfWorkflowServicesProvidesPort)this.services.getConnectedProvidesPort(this.workflowServicesUsesPort.getName());
			} catch (HShelfException e1) {
				e1.printStackTrace();
			}
			
			HShelfConsoleLogger.write("Calling INSTANTIATE from :"+this.getName()+", KIND: " + this.getKind());
			//String safeSWLCode = FileUtil.readFileAsString(safeSWLPath);
			/*D-1 : PASSA COMO ARGUMENTO O MANIPULADOR DE SESSÃO E A REFERENCIA DO COMPONENTENO CÓDIGO */
			providesWorkflowPort.instantiate(null,null);
		}
		
		
	}
	
	 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean hasServices(){
		if(this.services==null) return false;
		return true;
	}
	
	public String getContract() {
		return contractPath;
	}

	public void setContract(String contract) {
		this.contractPath = contract;
	}

	 

	public String getSafeSWLPath() {
		return safeSWLPath;
	}

	public void setSafeSWLPath(String safeSWLPath) {
		this.safeSWLPath = safeSWLPath;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public String getSelectionPortName(){
		return  "application-selection-"+this.getName()+"-port-uses";
	}
	
	public String getWorkflowServicesPortName(){
		return "workflow-services-"+this.getName()+"-port-uses";
	}
	
	public String getLifeCyclePortName(){
		return "lyfe-cycle-"+this.getName()+"-port";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof HShelfComponent))
			return false;
		HShelfComponent ref = (HShelfComponent)obj;
		if(ref.getName().equals(this.name))
			return true;
		return false;
	}
}
