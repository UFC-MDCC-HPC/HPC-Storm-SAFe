package br.ufc.montage.be;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface I_MontageDir {

	@WebMethod
	public String getRawDir();
	@WebMethod
	public String getProjDir();
	@WebMethod
	public String getCorrDir();
	@WebMethod
	public String getDiffDir();
	@WebMethod
	public String getDss2bDir();
	@WebMethod
	public String getDss2rDir();
	@WebMethod
	public String getDss2irDir();
	@WebMethod
	public String getFitsDir();
	
	
}
