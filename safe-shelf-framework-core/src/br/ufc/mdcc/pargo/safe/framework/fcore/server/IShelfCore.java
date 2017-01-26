package br.ufc.mdcc.pargo.safe.framework.fcore.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IShelfCore {
	
	/**
	 * 
	 * @param contract of a component;
	 * @return a list of candidates;
	 */
	@WebMethod
	public String resolve(String contract);
	/**
	 * 
	 * @param candidates ordered
	 * @return ID of the first candidate deployed.
	 */
	@WebMethod
	public String deploy(String safeSWLCode, String componentReference);
	/**
	 * 
	 * @param ID of the first candidate deployed
	 * @return URL informations from its ports in XML format. See documentation.
	 */
	@WebMethod
	public String instantiate(String wsession, String reference);
	/**
	 * 
	 * @param ID of the component to be released
	 */
	@WebMethod
	public void release(String ID);
	@WebMethod
	public String listParameter(String contract);
	@WebMethod
	public void setComponentList(String componentList);

}
