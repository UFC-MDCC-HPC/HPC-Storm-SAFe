package br.ufc.m101.component.mprojexec;

import br.ufc.m101.component.M101Component;
import br.ufc.m101.util.UnixUtil;

public class MProjExec extends M101Component{

	public void go(){
		String cmd = "mProjExec "+this.params;
		UnixUtil.executeCommand(cmd);
	}
}
