package br.ufc.mdcc.pargo.safe.expert.client;

import br.ufc.mdcc.pargo.safe.expert.stub.HPCStormApplicationServerImplService;
import br.ufc.mdcc.pargo.safe.expert.stub.IHPCStormApplicationServer;
import br.ufc.mdcc.pargo.safe.expert.util.FileUtil;

 
/**
 * Connects do SAFe SERVER e call its services
 * @author jefferson
 *
 */
public class SAFeClient {
	
	private IHPCStormApplicationServer port;
	
	public SAFeClient() {
		HPCStormApplicationServerImplService service = new HPCStormApplicationServerImplService();
		this.port = service.getHPCStormApplicationServerImplPort();
	}
	
	
	public void setSAFeSWLArchSource(String filePath, String fileName){
		String source = FileUtil.readFileAsString(filePath);
		this.port.setSAFeSWLArchSource(source, fileName);
	}
	
	public void setSAFeSWLFlowSource(String filePath, String fileName){
		String source = FileUtil.readFileAsString(filePath);
		this.port.setSAFeSWLFlowSource(source, fileName);
	}
	
	public void run(){
		this.port.run();
	}
	
}
