package br.ufc.montage.be;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface I_mArchiveList {

	@WebMethod
	public String getTblProvides();
	@WebMethod
	public void setRawUses(String value);
	@WebMethod
	public void go();
}
