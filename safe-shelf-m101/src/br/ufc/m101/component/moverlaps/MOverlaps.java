package br.ufc.m101.component.moverlaps;

import br.ufc.m101.component.M101Component;
import br.ufc.m101.util.UnixUtil;

public class MOverlaps extends M101Component{

	public void go(){
		String cmd = "mOverlaps "+this.params;
		UnixUtil.executeCommand(cmd);
	}
}
