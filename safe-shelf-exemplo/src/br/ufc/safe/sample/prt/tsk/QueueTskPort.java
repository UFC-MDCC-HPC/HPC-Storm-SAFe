package br.ufc.safe.sample.prt.tsk;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfTaskPort;
import br.ufc.safe.sample.stubs.queue.tsk.IQueueServiceTsk;
import br.ufc.safe.sample.stubs.queue.tsk.QueueServiceTskService;

public class QueueTskPort extends HShelfTaskPort{
	
	public void go(){
		QueueServiceTskService service = new QueueServiceTskService();
		IQueueServiceTsk port = service.getQueueServiceTskPort();
		port.go();
	}
}
