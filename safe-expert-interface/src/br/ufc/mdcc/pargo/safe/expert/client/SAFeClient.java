package br.ufc.mdcc.pargo.safe.expert.client;

import br.ufc.mdcc.pargo.safe.expert.stub.HPCStormApplicationServerImplService;
import br.ufc.mdcc.pargo.safe.expert.stub.IHPCStormApplicationServer;
import br.ufc.mdcc.pargo.safe.expert.util.FileUtil;

 

public class SAFeClient {

	private String readArchSource(){
		String source = "";
		String archLocation = FileUtil.readProperty("safe_expert_dir")+"mImgtbl-simple-run-arch.xml";
		source = FileUtil.readFileAsString(archLocation);
		return source;
	}
	
	private String readFlowSource(){
		String source = "";
		String flowLocation = FileUtil.readProperty("safe_expert_dir")+"mImgtbl-simple-run-flow.xml";
		source = FileUtil.readFileAsString(flowLocation);
		return source;
	}
	
	/**
	 * LINK COM O SAFE REMOTO!!! COLOCAR NA GUI!
	 */
	public void run(){
		HPCStormApplicationServerImplService service = new HPCStormApplicationServerImplService();
		IHPCStormApplicationServer port = service.getHPCStormApplicationServerImplPort();
		port.setSAFeSWLArchSource(this.readArchSource(), "mImgtbl-simple-run-arch.xml");
		port.setSAFeSWLFlowSource(this.readFlowSource(), "mImgtbl-simple-run-flow.xml");
		port.run();
	}
}
