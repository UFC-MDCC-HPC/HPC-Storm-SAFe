package br.ufc.safe.sample.cmp;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.safe.sample.prt.tsk.QueueTskPort;

public class QueueComponentProxie extends HShelfComponent{

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		
		QueueTskPort queueTskPort = new QueueTskPort();
		queueTskPort.setName("queue-tsk");
		try {
			this.services.registerTaskPort(queueTskPort);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
