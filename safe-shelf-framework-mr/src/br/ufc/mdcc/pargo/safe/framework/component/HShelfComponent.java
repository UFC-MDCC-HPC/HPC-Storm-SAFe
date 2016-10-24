package br.ufc.mdcc.pargo.safe.framework.component;

import java.util.ArrayList;
import java.util.List;

import br.ufc.mdcc.pargo.safe.framework.core.HShelfCoreHPEImpl;
import br.ufc.mdcc.pargo.safe.framework.core.IHShelfCore;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfSelectionPort;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.framework.util.HShelfConsoleLogger;
import br.ufc.mdcc.pargo.safe.grammar.arch.SAFeOrquestrationArchitecture;
import br.ufc.mdcc.pargo.safe.grammar.util.FileUtil;
import br.ufc.mdcc.pargo.safe.grammar.util.XMLManipulator;

public abstract class HShelfComponent {

	private String name;
	private String contractPath;
	private String kind;
	protected IHShelfService services;
	
	private IHShelfCore core = new HShelfCoreHPEImpl();
	private HShelfUsesPort workflowServicesUsesPort;
	
	private String safeSWLPath;
	private String backEndAdress = null;
	private String coreXMLReturn; // RETORNO DO CORE
	
	private List<Object> permuted; //RETORNO DA APLICAÇÃO
	private Object selectedCandidate;
	
	private boolean isDeployActivated = false; 
	private boolean isInstantiateActivated = false;
	
	
	
	public abstract void setServices(IHShelfService services);

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

	/**CORE COM**/
	public void resolve(){
		HShelfConsoleLogger.write("Calling RESOLVE from :"+this.getName()+", KIND: " + this.getKind());
		String content = FileUtil.readFileAsString(contractPath); //CONTEÚDO DO CONTRATO CONTEXTUAL DESSE COMPONENTE
		this.coreXMLReturn = this.core.resolve(content); //RETORNO DO CORE COM OS COMPONENTES QUE ATENDEM
		try {
			HShelfUsesPort uses = (HShelfUsesPort) this.services.getPort("application-selection-"+this.getName()+"-port-uses");
			HShelfSelectionPort selection = (HShelfSelectionPort)uses.getProvidesPort();
		    this.permuted = selection.selection(this.createDataStructureFromCoreXML(this.coreXMLReturn));//ENVIA OS OBJETOS PARA A APLICAÇÃO QUE OS RETORNA PERMUTADOS
		} catch (HShelfException e) {
			
			e.printStackTrace();
		}
		this.isDeployActivated = true; //ATIVA A AÇÃO? 
	}
	
	public void deploy(){
		if(isDeployActivated){
			
			HShelfConsoleLogger.write("Calling DEPLOY from :"+this.getName()+", KIND: " + this.getKind());
			for(Object candidate:this.permuted){
				String safeSWLCode = FileUtil.readFileAsString(safeSWLPath);
				if(this.kind.equals(SAFeOrquestrationArchitecture.PLATFORM)){
					this.backEndAdress = this.core.deploy(safeSWLCode,this.getName(),candidate); 
					if(this.backEndAdress!=null){
						XMLManipulator.changeComponentAddressAtt(safeSWLPath, this.name, this.backEndAdress);
						isInstantiateActivated = true;
						selectedCandidate = candidate;
						break;
					}
				}else if(this.kind.equals(SAFeOrquestrationArchitecture.COMPUTATION) ||
						this.kind.equals(SAFeOrquestrationArchitecture.CONNECTOR)) {
						this.core.deploy(safeSWLCode,this.getName(),candidate);
						isInstantiateActivated = true;
						selectedCandidate = candidate;
						break;
				}
				
			}
		}
	}
	
	public void instantiate(){
		if(isInstantiateActivated){
			HShelfConsoleLogger.write("Calling INSTANTIATE from :"+this.getName()+", KIND: " + this.getKind());
			String safeSWLCode = FileUtil.readFileAsString(safeSWLPath);
			this.core.instantiate(safeSWLCode,this.getName());
		}
		
		
	}
	
	private List<Object> createDataStructureFromCoreXML(String coreXML){
		List<Object> res = new ArrayList<Object>();
		res.add(new Object());
		return res;
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
