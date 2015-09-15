package br.ufc.mdcc.pargo.safe.application.sample;

import br.ufc.mdcc.pargo.safe.application.HPCStormApplication;
import br.ufc.mdcc.pargo.safe.port.predef.SAFeSWLProvidesPort;
import br.ufc.mdcc.pargo.safe.service.IHPCStormServices;
import br.ufc.mdcc.pargo.safe.util.FileUtil;

/**
 * Just a sample application at SERVER SIDE.
 * @author jefferson
 *
 */
public class ApplicationSample extends HPCStormApplication{

	
	
	public ApplicationSample() {
		super();
		this.safeFeSWLPort = new SAFeSWLProvidesPort();
		this.services.registerProvidesPort(this.safeFeSWLPort);
	}
	
	public void setSAFeSWLArchSource(String source, String fileName){
		SAFeSWLProvidesPort ref = (SAFeSWLProvidesPort)this.safeFeSWLPort;
		String path = FileUtil.readProperty("safe_dir").trim() + fileName.trim();
		FileUtil.saveStringIntoAFile(source, path);
		ref.setFileArchPath(path);
		
		
	}
	
	public void setSAFeSWLFlowSource(String source, String fileName){
		SAFeSWLProvidesPort ref = (SAFeSWLProvidesPort)this.safeFeSWLPort;
		String path = FileUtil.readProperty("safe_dir").trim() + fileName.trim();
		FileUtil.saveStringIntoAFile(source, path);
		ref.setFileFlowPath(path);
	}
	
	@Override
	public void setServices(IHPCStormServices services) {
		this.services = services;
	}
	
	 
	
}
