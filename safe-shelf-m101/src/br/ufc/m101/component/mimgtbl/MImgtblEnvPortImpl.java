package br.ufc.m101.component.mimgtbl;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.m101.component.mimgtbl.MImgtblEnvPort")
public class MImgtblEnvPortImpl implements MImgtblEnvPort{

	private MImgtbl mImgtbl;
	
	public void setMImgtbl(MImgtbl mImgtbl){
		this.mImgtbl = mImgtbl;
	}
	
	@WebMethod
	public void setParams(String params){
		this.mImgtbl.setParams(params);
	}
}
