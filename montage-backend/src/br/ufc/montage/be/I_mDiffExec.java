package br.ufc.montage.be;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface I_mDiffExec {

	@WebMethod
	public void setTblPortUses(String value);
	@WebMethod
	public void setDirPortUsesIn(String value);
	@WebMethod
	public void setDirPortUsesOut(String value);
	@WebMethod
	public void setHdrPortUses(String value);
	@WebMethod
	public void go();
}
