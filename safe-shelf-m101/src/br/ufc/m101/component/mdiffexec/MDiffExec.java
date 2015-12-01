package br.ufc.m101.component.mdiffexec;

import br.ufc.m101.component.M101Component;
import br.ufc.m101.util.UnixUtil;

public class MDiffExec extends M101Component{

	public void go(){
		String cmd = "mDiffExec "+this.params;
		UnixUtil.executeCommand(cmd);
	}
}
