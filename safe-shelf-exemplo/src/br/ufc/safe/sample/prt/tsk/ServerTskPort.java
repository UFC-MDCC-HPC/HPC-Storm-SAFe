package br.ufc.safe.sample.prt.tsk;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfTaskPort;
import br.ufc.safe.sample.stubs.server.tsk.ServerServiceTsk;
import br.ufc.safe.sample.stubs.server.tsk.ServerServiceTskService;

public class ServerTskPort extends HShelfTaskPort{
	
	public void get(){
		ServerServiceTskService service = new ServerServiceTskService();
		ServerServiceTsk port = service.getServerServiceTskPort();
		port.get();
	}
	
	public void request(){
		ServerServiceTskService service = new ServerServiceTskService();
		ServerServiceTsk port = service.getServerServiceTskPort();
		port.request();
	}

}
