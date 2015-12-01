package br.ufc.m101.component.moverlaps;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.m101.component.moverlaps.MOverlapsEnvPort")
public class MOverlapsEnvPortImpl implements MOverlapsEnvPort{

	private MOverlaps mOverlaps;
	
	public void setMOverlaps(MOverlaps mOverlaps){
		this.mOverlaps = mOverlaps;
	}
	
	@WebMethod
	public void setParams(String params){
		this.mOverlaps.setParams(params);
	}
}
