package br.ufc.mdcc.pargo.safe.application.component;

import java.util.ArrayList;
import java.util.List;

public class MontageComponent {

	private String name;
	private List<MontageParam> inParams;
	private List<MontageParam> outParams;
	
	public MontageComponent(String name) {
		this.name = name;
		this.inParams = new ArrayList<MontageParam>();
		this.outParams = new ArrayList<MontageParam>();
	}
	
	public void addInParam(MontageParam inParam){
		this.inParams.add(inParam);
	}
	
	public void addOutParam(MontageParam outParam){
		this.outParams.add(outParam);
	}

	public MontageParam getInParam(String name){
		MontageParam mpFake = new MontageParam(name, "");
		int index = this.inParams.indexOf(mpFake);
		return this.inParams.get(index);
	}
	
	public MontageParam getOutParam(String name){
		MontageParam mpFake = new MontageParam(name, "");
		int index = this.outParams.indexOf(mpFake);
		return this.outParams.get(index);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MontageParam> getInParams() {
		return inParams;
	}

	public List<MontageParam> getOutParams() {
		return outParams;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof MontageComponent))
			return false;
		MontageComponent ref = (MontageComponent)obj;
		if(!ref.getName().equals(this.name))
			return false;
		return true;
	}
	
	
	
}
