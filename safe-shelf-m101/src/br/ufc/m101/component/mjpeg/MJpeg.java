package br.ufc.m101.component.mjpeg;

import br.ufc.m101.component.M101Component;
import br.ufc.m101.util.UnixUtil;

public class MJpeg extends M101Component{
	
	public void go(){
		String cmd = "mJPEG "+this.params;
		UnixUtil.executeCommand(cmd);
	}
}
