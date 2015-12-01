package br.ufc.m101.component.mimgtbl;

import br.ufc.m101.component.M101Component;
import br.ufc.m101.util.UnixUtil;

public class MImgtbl extends M101Component{

	public void go(){
		String cmd = "mImgtbl "+this.params;
		UnixUtil.executeCommand(cmd);
	}
}
