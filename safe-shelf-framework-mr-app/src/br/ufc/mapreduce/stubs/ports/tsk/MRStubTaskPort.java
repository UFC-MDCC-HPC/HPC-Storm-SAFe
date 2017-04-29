package br.ufc.mapreduce.stubs.ports.tsk;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfActionPort;

public class MRStubTaskPort extends HShelfActionPort{

	@Override
	public void invoke(Object action) {
		System.out.println("@INVOKE "+action.toString());
	}
}
