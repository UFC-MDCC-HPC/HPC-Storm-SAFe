package br.ufc.mdcc.pargo.safe.sample.cca;

import br.ufc.mdcc.pargo.safe.port.HShelfPort;

public class ShelfHelloServerPort extends HShelfPort{

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
