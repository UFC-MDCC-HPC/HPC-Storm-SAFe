package br.ufc.safe.sample.cmp;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.safe.sample.prt.env.ClientAddMessageEnvPort;
import br.ufc.safe.sample.prt.tsk.ClientTskPort;

public class ClientComponentProxie extends HShelfComponent{

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		
		ClientAddMessageEnvPort clientAddMessageEnvPort =
				new ClientAddMessageEnvPort();
		clientAddMessageEnvPort.setName("client-add-msg-provides");
		
		ClientTskPort tsk = new ClientTskPort();
		tsk.setName("client-tsk");
		
		try {
			this.services.setProvidesPort(clientAddMessageEnvPort);
			this.services.registerTaskPort(tsk);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
