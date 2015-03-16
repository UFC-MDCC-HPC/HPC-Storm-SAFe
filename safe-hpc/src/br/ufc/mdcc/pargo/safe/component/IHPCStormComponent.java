package br.ufc.mdcc.pargo.safe.component;

import br.ufc.mdcc.pargo.safe.application.IHPCStormServices;



public interface IHPCStormComponent {

	/**
	 * The services object is created by the framework and then assigned to the application.
	 * It is a singleton object shared by the other SAFe entities.
	 * @param services
	 */
	public void setServices(IHPCStormServices services);
}
