package br.ufc.m101.component.mjpeg;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MJpegEnvPort {

	@WebMethod
	public void setParams(String params);
}
