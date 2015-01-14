package br.ufc.mdcc.pargo.safe.session;

import br.ufc.mdcc.pargo.safe.base.IHStormWorkflowEngine;
import br.ufc.mdcc.pargo.safe.base.IHStormWorkflowSession;

public class HStormSession implements Runnable{

	private IHStormWorkflowSession hStormWorkflowSession; //Application component
	private IHStormWorkflowEngine hStormWorkflowEngine; //Workflow component 
	private Integer id;
	
	public HStormSession(IHStormWorkflowSession hStormWorkflowSession) {
		this.hStormWorkflowSession = hStormWorkflowSession;
	}
	
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	public IHStormWorkflowSession gethStormWorkflowSession() {	
		return hStormWorkflowSession;
	}
	public IHStormWorkflowEngine gethStormWorkflowEngine() {
		return hStormWorkflowEngine;
	}
	public void sethStormWorkflowEngine(IHStormWorkflowEngine hStormWorkflowEngine) {
		this.hStormWorkflowEngine = hStormWorkflowEngine;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
