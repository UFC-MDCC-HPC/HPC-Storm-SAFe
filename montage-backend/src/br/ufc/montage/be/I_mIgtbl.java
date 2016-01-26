package br.ufc.montage.be;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface I_mIgtbl {

	@WebMethod
	public void setDirPortUses(String value);
	@WebMethod
	public String getTblPortProvides();
	@WebMethod
	public void go();
}
