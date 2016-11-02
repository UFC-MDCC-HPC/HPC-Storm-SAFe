package br.ufc.mdcc.pargo.safe.framework.core;

public interface IHShelfCore {

	/**
	 * 
	 * @param contract of a component;
	 * @return a list of candidates;
	 */
	public String resolve(String contract);
	/**
	 * 
	 * @param candidates ordered
	 * @return ID of the first candidate deployed.
	 */
	public String deploy(String safeSWLCode, String componentReference);
	/**
	 * 
	 * @param ID of the first candidate deployed
	 * @return URL informations from its ports in XML format. See documentation.
	 */
	public String instantiate(Object wsession, Object reference);
	/**
	 * 
	 * @param ID of the component to be released
	 */
	public void release(String ID);
	
	public String parameterList(String contract);
	public void setComponentList(String componentList);
}
