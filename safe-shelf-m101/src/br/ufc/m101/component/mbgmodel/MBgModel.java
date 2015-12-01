package br.ufc.m101.component.mbgmodel;

import br.ufc.m101.component.M101Component;
import br.ufc.m101.util.UnixUtil;

public class MBgModel extends M101Component{

	public void go(){
		String cmd = "mBgModel "+this.params;
		UnixUtil.executeCommand(cmd);
	}
}
