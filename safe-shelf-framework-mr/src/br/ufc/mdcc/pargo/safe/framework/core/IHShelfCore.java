package br.ufc.mdcc.pargo.safe.framework.core;

public interface IHShelfCore {

	/**
	 * 
	 * @param contract of a component;
	 * @return a list of candidates;
	 */
	public Object resolve(String contract);
	/**
	 * 
	 * @param candidates ordered
	 * @return ID of the first candidate deployed.
	 */
	public Object deploy(String safeSWLCode, Object componentReference);
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
	
	public Object listParameter(String contract);
	public void setComponentList(Object componentList);
}
