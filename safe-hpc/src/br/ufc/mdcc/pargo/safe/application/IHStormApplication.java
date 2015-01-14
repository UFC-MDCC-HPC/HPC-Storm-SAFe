package br.ufc.mdcc.pargo.safe.application;

import br.ufc.mdcc.pargo.safe.base.IHStormWorkflowSession;
import br.ufc.mdcc.pargo.safe.session.HStormSession;
/**
 * This interface represents the application at client-side.
 * @author jefferson
 *
 */
public interface IHStormApplication {
	
	public HStormSession newWorkflowSession(IHStormWorkflowSession hStormWorkflowSession);
	 

}
