package br.ufc.mdcc.pargo.safe.core;

import java.util.List;

/**
 * Inteface with CORE main services.
 * @author jefferson
 *
 */
public interface ICoreRemoteServices {

	public List<String> resolveComponent(Integer compId, Integer contractId);
	public Boolean instantiate(Integer compId);
}
