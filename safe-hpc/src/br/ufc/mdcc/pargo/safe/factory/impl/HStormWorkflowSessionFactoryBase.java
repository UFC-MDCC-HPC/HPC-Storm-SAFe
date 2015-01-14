package br.ufc.mdcc.pargo.safe.factory.impl;

import br.ufc.mdcc.pargo.safe.base.IHStormWorkflowSession;
import br.ufc.mdcc.pargo.safe.base.impl.HStormWorkflowSessionBase;
import br.ufc.mdcc.pargo.safe.factory.IHStormWorkflowSessionFactory;

public class HStormWorkflowSessionFactoryBase implements IHStormWorkflowSessionFactory {

	@Override
	public IHStormWorkflowSession createHStormWorkflowSession() {
		return new HStormWorkflowSessionBase();
	}

}
