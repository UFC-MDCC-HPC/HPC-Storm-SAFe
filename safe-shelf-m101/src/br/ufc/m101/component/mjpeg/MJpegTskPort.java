package br.ufc.m101.component.mjpeg;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface MJpegTskPort {

	@WebMethod
	public void go();
}
