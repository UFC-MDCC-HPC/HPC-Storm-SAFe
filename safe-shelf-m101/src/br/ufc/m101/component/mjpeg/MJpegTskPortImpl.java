package br.ufc.m101.component.mjpeg;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "br.ufc.m101.component.mjpeg.MJpegTskPort")
public class MJpegTskPortImpl implements MJpegTskPort {

	private MJpeg mJpeg;

	public void setMJpeg(MJpeg mJpeg) {
		this.mJpeg = mJpeg;
	}

	@WebMethod
	public void go() {
		this.mJpeg.go();
	}
}
