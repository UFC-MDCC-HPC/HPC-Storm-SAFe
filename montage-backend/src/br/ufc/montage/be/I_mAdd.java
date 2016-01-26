package br.ufc.montage.be;

import javax.jws.WebMethod;
import javax.jws.WebService;

 
@WebService
public interface I_mAdd {

	@WebMethod
	public String getfitsPortProvides();
	@WebMethod
	public void setTblPortUses(String value);
	@WebMethod
	public void setDirPortUses(String value);
	@WebMethod
	public void setHdrPortUses(String value);
	@WebMethod
	public void go();
}
