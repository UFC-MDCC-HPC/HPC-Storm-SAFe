package br.ufc.montage.be;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface I_mBgExec {
	@WebMethod
	public void setTblPortUsesA(String value);
	@WebMethod
	public void setTblPortUsesB(String value);

	@WebMethod
	public void setDirPortUsesIn(String value);
	@WebMethod
	public void setDirPortUsesOut(String value);
	
	@WebMethod
	public void go();

}
