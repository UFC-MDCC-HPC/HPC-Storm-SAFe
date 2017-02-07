package br.ufc.montage.ports.tsk;

import br.ufc.mdcc.pargo.safe.framework.port.HShelfTaskPort;

public class MontageTaskPort extends HShelfTaskPort{
	
	@Override
	public void invoke(Object action) {
		System.out.println("@INVOKE MNTG "+action.toString());
	}

}
