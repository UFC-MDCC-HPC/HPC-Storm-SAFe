package br.ufc.m101.component.madd;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.m101.component.madd.MAddEnvPort")
public class MAddEnvPortImpl implements MAddEnvPort{

	private MAdd mAdd;
	
	public void setMAdd(MAdd mAdd){
		this.mAdd = mAdd;
	}
	
	@Override
	@WebMethod
	public void setParams(String params) {
		this.mAdd.setParams(params);
	}

}
