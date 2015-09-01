package br.ufc.mdcc.pargo.safe.core;


/**
 * Inteface with CORE main services.
 * @author jefferson
 *
 */
public interface ICoreRemoteServices {

	/**
	 * in: a context_contrac in xml format
	 * out: list of candidates in xml format
	 */
	public String resolve(String xml);
	/**
	 * in: a list of context_contract in xml format
	 * out: session URI
	 */
	public String deploy(String xml);
	/**
	 * in: session URI
	 * out: running web-service component address
	 */
	public String instantiate(String xml);
	/**
	 * in: session URI
	 * out: OK or NOK message output
	 */
	public String release(String xml);
}
