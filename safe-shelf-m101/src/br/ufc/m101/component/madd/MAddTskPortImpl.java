package br.ufc.m101.component.madd;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.m101.component.madd.MAddTskPort")
public class MAddTskPortImpl implements MAddTskPort {

	private MAdd mAdd;

	public void setMAdd(MAdd mAdd) {
		this.mAdd = mAdd;
	}

	@Override
	@WebMethod
	public void go() {
		this.mAdd.go();

	}

}
