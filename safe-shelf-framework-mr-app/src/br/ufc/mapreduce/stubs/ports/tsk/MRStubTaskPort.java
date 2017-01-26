package br.ufc.mapreduce.stubs.ports.tsk;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfTaskPort;

public class MRStubTaskPort extends HShelfTaskPort{

	@Override
	public void invoke(Object action) {
		System.out.println("@INVOKE "+action.toString());
	}
}
