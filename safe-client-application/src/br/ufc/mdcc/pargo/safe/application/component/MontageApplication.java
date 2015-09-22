package br.ufc.mdcc.pargo.safe.application.component;

import java.util.ArrayList;
import java.util.List;

public class MontageApplication {

	private String name;
	private List<MontageParam> inParams;
	private List<MontageParam> outParams;

	public MontageApplication(String name) {
		this.name = name;
		this.inParams = new ArrayList<MontageParam>();
		this.outParams = new ArrayList<MontageParam>();
	}

	public void addInParam(MontageParam inParam) {
		this.inParams.add(inParam);
	}

	public void addOutParam(MontageParam outParam) {
		this.outParams.add(outParam);
	}

	public MontageParam getInParam(String name) {

		MontageParam mpFake = new MontageParam(name, "");
		int index = this.inParams.indexOf(mpFake);
		if (index >= 0)
			return this.inParams.get(index);
		return null;
	}

	public MontageParam getOutParam(String name) {
		MontageParam mpFake = new MontageParam(name, "");
		int index = this.outParams.indexOf(mpFake);
		if (index >= 0)
			return this.outParams.get(index);
		return null;
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
		if(!(obj instanceof MontageApplication))
			return false;
		MontageApplication ref = (MontageApplication)obj;
		if(!ref.getName().equals(this.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		String res = "name: "+this.name;
		res+="\n\tIN:\n ";
		for(MontageParam mp:inParams){
			res+="\t\t"+mp+"\n";
		}
		res+="\tOUT:\n ";
		for(MontageParam mp:outParams){
			res+="\t\t"+mp+"\n";
		}
		return res;
	}
}
