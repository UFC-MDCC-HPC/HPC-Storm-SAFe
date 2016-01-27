package br.ufc.montage.be;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface I_mArchiveExec {

	@WebMethod
	public void setTblUses(String value);
	@WebMethod
	public void setDirUses(String value);
	@WebMethod
	public void go();
}
