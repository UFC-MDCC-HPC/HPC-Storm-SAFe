package br.ufc.m101.component.moverlaps;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "br.ufc.m101.component.moverlaps.MOverlapsTskPort")
public class MOverlapsTskPortImpl implements MOverlapsTskPort {

	private MOverlaps mOverlaps;

	public void setMOverlaps(MOverlaps mOverlaps) {
		this.mOverlaps = mOverlaps;
	}

	@WebMethod
	public void go() {
		this.mOverlaps.go();
	}
}
