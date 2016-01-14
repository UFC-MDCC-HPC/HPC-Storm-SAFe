package br.ufc.safe.sample.service.queue;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.ufc.safe.sample.cmp.QueueBE;

@WebService(endpointInterface="br.ufc.safe.sample.service.queue.IQueueServiceTsk")
public class QueueServiceTsk implements IQueueServiceTsk{

	private QueueBE queueBE;

	public QueueServiceTsk(QueueBE queueBE) {
		this.queueBE = queueBE;
	}
	
	@Override
	@WebMethod
	public void go() {
		this.queueBE.go();
	}

}
