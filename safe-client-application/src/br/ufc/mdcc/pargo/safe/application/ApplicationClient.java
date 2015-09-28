package br.ufc.mdcc.pargo.safe.application;

import br.ufc.mdcc.pargo.safe.application.stub.HPCStormApplicationServerImplService;
import br.ufc.mdcc.pargo.safe.application.stub.IHPCStormApplicationServer;
import br.ufc.mdcc.pargo.safe.util.FileUtil;

/**
 * Communicates with ws-server safe
 * @author jefferson
 *
 */
public class ApplicationClient {

	////String archLocation = "/home/jefferson/Git/HPC-Storm-SAFe/safe-hpc/src/br/ufc/mdcc/pargo/safe/grammar/xml/m101-arch.xml";
	//String flowLocation = "/home/jefferson/Git/HPC-Storm-SAFe/safe-hpc/src/br/ufc/mdcc/pargo/safe/grammar/xml/m101-flow.xml";
			
	
	private String readArchSource(){
		String source = "";
		String archLocation = FileUtil.readProperty("safe_client_dir")+"m101-arch.xml";
		source = FileUtil.readFileAsString(archLocation);
		return source;
	}
	
	private String readFlowSource(){
		String source = "";
		String flowLocation = FileUtil.readProperty("safe_client_dir")+"m101-flow.xml";
		source = FileUtil.readFileAsString(flowLocation);
		return source;
	}
	
	/**
	 * LINK COM O SAFE REMOTO!!! COLOCAR NA GUI!
	 */
	public void run(){
		HPCStormApplicationServerImplService service = new HPCStormApplicationServerImplService();
		IHPCStormApplicationServer port = service.getHPCStormApplicationServerImplPort();
		port.setSAFeSWLArchSource(this.readArchSource(), "arch-m101.xml");
		port.setSAFeSWLFlowSource(this.readFlowSource(), "flow-m101.xml");
		port.run();
	}
	
	/*public static void main(String[] args) {
		ApplicationClient client = new ApplicationClient();
		client.run();
	}*/
}
