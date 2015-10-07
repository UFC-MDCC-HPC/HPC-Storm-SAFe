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
	 * @return ID of the first candidate deployed
	 */
	public String deploy(String candidates);
	/**
	 * 
	 * @param ID of the first candidate deployed
	 * @return URL informations from its ports
	 */
	public String instantiate(String ID);
	/**
	 * 
	 * @param ID of the component to be released
	 */
	public void release(String ID);
}
