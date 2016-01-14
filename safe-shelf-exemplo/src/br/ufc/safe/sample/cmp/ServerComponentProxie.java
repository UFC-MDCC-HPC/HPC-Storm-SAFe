package br.ufc.safe.sample.cmp;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.safe.sample.prt.tsk.ServerTskPort;

public class ServerComponentProxie extends HShelfComponent{

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		ServerTskPort serverTskPort = new ServerTskPort();
		serverTskPort.setName("server-tsk");
		try {
			this.services.registerTaskPort(serverTskPort);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
