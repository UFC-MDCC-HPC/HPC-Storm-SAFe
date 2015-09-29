package br.ufc.mdcc.pargo.safe.sample.basic;

/**
 * Application
 */
import br.ufc.mdcc.pargo.safe.application.HShelfApplication;
import br.ufc.mdcc.pargo.safe.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.port.dflt.HShelfGoPort;
import br.ufc.mdcc.pargo.safe.port.dflt.HShelfSAFeSWLPort;
import br.ufc.mdcc.pargo.safe.services.IHShelfService;

public class SAFeSampleApplication extends HShelfApplication{
	
	public SAFeSampleApplication(String name) {
		super(name);
	}

	@Override
	public void setServices(IHShelfService services) {
		this.services = services; 
	}
	
	
	public static void main(String[] args) {
		SAFeSampleApplication sampleApp = new SAFeSampleApplication("sample-app");
		IHShelfService services = sampleApp.getServices();
		try {
		 
			System.out.println("PASSO 1");
			HShelfPort portSWL = services.getProvidesPort("safeswl-port");
			
			((HShelfSAFeSWLPort)portSWL).setSAFeSWLArchFilePath("/home/jefferson/Git/HPC-Storm-SAFe/safe-shelf-language/src/br/ufc/mdcc/pargo/safe/grammar/xml/mImgtbl-simple-run-arch.xml");
			((HShelfSAFeSWLPort)portSWL).setSAFeSWLFlowFilePath("/home/jefferson/Git/HPC-Storm-SAFe/safe-shelf-language/src/br/ufc/mdcc/pargo/safe/grammar/xml/mImgtbl-simple-run-flow.xml");
			
			System.out.println("PASSO 2");
			HShelfPort portGo = services.getProvidesPort("go-workflow");
			((HShelfGoPort)portGo).go();

			
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
