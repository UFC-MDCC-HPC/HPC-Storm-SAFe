package br.ufc.montage.be;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
public interface I_mFitExec {

	@WebMethod
	public String getTblPortProvides();
	@WebMethod
	public void setTblPortUses(String value);
	@WebMethod
	public void setDirPortUses(String value);
	@WebMethod
	public void go();
	
}
