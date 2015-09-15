package br.ufc.mdcc.pargo.safe.application.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.ufc.mdcc.pargo.safe.application.sample.ApplicationSample;

@WebService(endpointInterface = "br.ufc.mdcc.pargo.safe.application.service.IHPCStormApplicationServer")
public class HPCStormApplicationServerImpl implements IHPCStormApplicationServer{

	//application server side...
	private ApplicationSample appSample;
	
	public HPCStormApplicationServerImpl() {
		this.appSample = new ApplicationSample();
	}
	
	@Override
	@WebMethod
	public void setSAFeSWLArchSource(String source, String fileName) {
		this.appSample.setSAFeSWLArchSource(source, fileName);
		
	}

	@Override
	@WebMethod
	public void setSAFeSWLFlowSource(String source, String fileName) {
		this.appSample.setSAFeSWLFlowSource(source, fileName);
	}

	@Override
	@WebMethod
	public void run() {
		this.appSample.run();
		
	}

}
