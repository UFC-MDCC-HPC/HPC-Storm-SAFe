package br.ufc.mdcc.pargo.safe.framework.component;

import java.util.ArrayList;
import java.util.List;

import br.ufc.mdcc.pargo.safe.framework.core.HShelfCoreHPEImpl;
import br.ufc.mdcc.pargo.safe.framework.core.IHShelfCore;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfSelectionPort;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.grammar.util.FileUtil;
import br.ufc.mdcc.pargo.safe.grammar.util.XMLManipulator;

public abstract class HShelfComponent {

	private String name;
	private String contractPath;
	protected IHShelfService services;
	
	private IHShelfCore core = new HShelfCoreHPEImpl();
	private String safeSWLPath;
	private String backEndAdress;
	private String coreXMLReturn; // RETORNO DO CORE
	private List<Object> permuted; //RETORNO DA APLICAÇÃO
	private boolean isDeployActivated = false; 
	private boolean isInstantiateActivated = false;
	private Object selectedCandidate;
	
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

	/**CORE COM**/
	public void resolve(){
		System.out.println("Calling RESOLVE from :"+this.getName());
		String content = FileUtil.readFileAsString(contractPath); //CONTEÚDO DO CONTRATO CONTEXTUAL DESSE COMPONENTE
		this.coreXMLReturn = this.core.resolve(content); //RETORNO DO CORE COM OS COMPONENTES QUE ATENDEM
		try {
			HShelfUsesPort uses = (HShelfUsesPort) this.services.getPort("application-selection-"+this.getName()+"-port-uses");
			HShelfSelectionPort selection = (HShelfSelectionPort)uses.getProvidesPort();
		    this.permuted = selection.selection(this.createDataStructureFromCoreXML(this.coreXMLReturn));//ENVIA OS OBJETOS PARA A APLICAÇÃO QUE OS RETORNA PERMUTADOS
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.isDeployActivated = true; //ATIVA A AÇÃO? GAMBI TOTAL
	}
	
	public void deploy(){
		if(isDeployActivated){
			System.out.println("Calling DEPLOY from :"+this.getName());
			
			for(Object candidate:this.permuted){
				String safeSWLCode = FileUtil.readFileAsString(safeSWLPath);
				this.backEndAdress = this.core.deploy(safeSWLCode,this.getName(),candidate); 
				if(this.backEndAdress!=null){
					XMLManipulator.changeComponentAddressAtt(safeSWLPath, this.name, this.backEndAdress);
					isInstantiateActivated = true;
					selectedCandidate = candidate;
					break;
				}
			}
		}
	}
	
	public void instantiate(){
		if(isInstantiateActivated){
			System.out.println("Calling INSTANTIATE from :"+this.getName());
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
