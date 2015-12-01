package br.ufc.m101.component.mjpeg;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="br.ufc.m101.component.mjpeg.MJpegEnvPort")
public class MJpegEnvPortImpl implements MJpegEnvPort{

	private MJpeg mJpeg;
	
	public void setMJpeg(MJpeg mJpeg){
		this.mJpeg = mJpeg;
	}
	
	@WebMethod
	public void setParams(String params){
		this.mJpeg.setParams(params);
	}
}
