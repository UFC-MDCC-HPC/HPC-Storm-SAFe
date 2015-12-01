package br.ufc.m101.component.mfitexec;

import br.ufc.m101.component.M101Component;
import br.ufc.m101.util.UnixUtil;

public class MFitExec extends M101Component{

	public void go(){
		String cmd = "mFitExec "+this.params;
		UnixUtil.executeCommand(cmd);
	}
}
