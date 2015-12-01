package br.ufc.m101.component.mbgexec;

import br.ufc.m101.component.M101Component;
import br.ufc.m101.util.UnixUtil;

public class MBgExec extends M101Component{

	public void go(){
		String cmd = "mBgExec "+this.params;
		UnixUtil.executeCommand(cmd);
	}
}
