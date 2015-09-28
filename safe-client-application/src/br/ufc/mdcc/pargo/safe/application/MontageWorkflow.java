package br.ufc.mdcc.pargo.safe.application;

import java.util.ArrayList;
import java.util.List;

import br.ufc.mdcc.pargo.safe.application.component.MontageComponent;

public class MontageWorkflow {

	private List<MontageComponent> workflow;
	
	public MontageWorkflow() {
		this.workflow = new ArrayList<MontageComponent>();
	}
	
	public void addComponentToWorkflow(MontageComponent mc){
		this.workflow.add(mc);
	}
	
	@Override
	public String toString() {
		String res = "";
		for(MontageComponent mc:workflow)
			res+=mc+"\n";
		return res;
	}
}
