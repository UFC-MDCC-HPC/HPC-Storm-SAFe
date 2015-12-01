package br.ufc.m101.component.mimgtbl;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "br.ufc.m101.component.mimgtbl.MImgtblTskPort")
public class MImgtblTskPortImpl implements MImgtblTskPort {

	private MImgtbl mImgtbl;

	public void setMImgtbl(MImgtbl mImgtbl) {
		this.mImgtbl = mImgtbl;
	}

	@WebMethod
	public void go() {
		this.mImgtbl.go();
	}
}
