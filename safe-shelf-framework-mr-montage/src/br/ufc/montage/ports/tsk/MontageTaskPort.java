package br.ufc.montage.ports.tsk;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfActionPort;

public class MontageTaskPort extends HShelfActionPort{
	
	@Override
	public void invoke(Object action) {
		System.out.println("@INVOKE MNTG "+action.toString());
	}

}
