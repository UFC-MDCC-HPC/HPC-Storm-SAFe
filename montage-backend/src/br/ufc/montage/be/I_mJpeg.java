package br.ufc.montage.be;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface I_mJpeg {

	@WebMethod
	public String getJpgPortProvides();
	@WebMethod
	public void setFitsPortUses(String value);
	@WebMethod
	public void go();
}
