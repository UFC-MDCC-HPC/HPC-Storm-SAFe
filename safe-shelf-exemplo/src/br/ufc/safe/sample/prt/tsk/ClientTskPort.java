package br.ufc.safe.sample.prt.tsk;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfTaskPort;
import br.ufc.safe.sample.stubs.client.tsk.ClientServiceTskService;
import br.ufc.safe.sample.stubs.client.tsk.IClientServiceTsk;

public class ClientTskPort extends HShelfTaskPort{

	public void post(){
		ClientServiceTskService service = new ClientServiceTskService();
		IClientServiceTsk port = service.getClientServiceTskPort();
		port.post();
	}
	
	public void send(){
		ClientServiceTskService service = new ClientServiceTskService();
		IClientServiceTsk port = service.getClientServiceTskPort();
		port.send();
	}
}
