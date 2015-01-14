package br.ufc.mdcc.pargo.safe.application.impl;

import java.util.HashMap;
import java.util.Map;

import br.ufc.mdcc.pargo.safe.application.IHStormApplication;
import br.ufc.mdcc.pargo.safe.base.IHStormWorkflowEngine;
import br.ufc.mdcc.pargo.safe.base.IHStormWorkflowSession;
import br.ufc.mdcc.pargo.safe.base.impl.HStormWorkflowEngineBase;
import br.ufc.mdcc.pargo.safe.factory.IHStormWorkflowSessionFactory;
import br.ufc.mdcc.pargo.safe.factory.impl.HStormWorkflowSessionFactoryBase;
import br.ufc.mdcc.pargo.safe.session.HStormSession;

public class HStormApplicationBase implements IHStormApplication{

	private Map<Integer, HStormSession> sessions;  
	private static Integer sessionId = 1;
	private IHStormWorkflowSessionFactory hstormWorkflowSessionFactory;
	
	public HStormApplicationBase() {
		this.sessions = new HashMap<Integer, HStormSession>();
		this.hstormWorkflowSessionFactory = new HStormWorkflowSessionFactoryBase();
		
	}
	
	@Override
	public HStormSession newWorkflowSession(
			IHStormWorkflowSession hStormWorkflowSession) {
		
		//creating IHStormWorkflowSession object via IHStormWorkflowSessionFactory
		hStormWorkflowSession = this.hstormWorkflowSessionFactory.createHStormWorkflowSession();
		//creating engine
		IHStormWorkflowEngine workflowEngine = new HStormWorkflowEngineBase();
		//creating the session
		HStormSession session = new HStormSession(hStormWorkflowSession); 
		//registering session
		session.setId(HStormApplicationBase.sessionId++);
		session.sethStormWorkflowEngine(workflowEngine);
		this.sessions.put(session.getId(), session);
		//connect application and workflow component ports
		//TODO
		
		return session;
	}
	
	

}
