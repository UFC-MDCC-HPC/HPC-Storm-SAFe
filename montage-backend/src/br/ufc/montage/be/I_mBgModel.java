package br.ufc.montage.be;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface I_mBgModel {

	@WebMethod
	public String getTblPortProvides();

	@WebMethod
	public void setTblPortUsesA(String value);
	@WebMethod
	public void settblPortUsesB(String value);
	@WebMethod
	public void go();
}
