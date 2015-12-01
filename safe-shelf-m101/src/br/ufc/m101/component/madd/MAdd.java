package br.ufc.m101.component.madd;

import br.ufc.m101.component.M101Component;
import br.ufc.m101.util.UnixUtil;

public class MAdd extends M101Component{

	public void go(){
		String cmd = "mAdd "+this.params;
		UnixUtil.executeCommand(cmd);
	}
}
