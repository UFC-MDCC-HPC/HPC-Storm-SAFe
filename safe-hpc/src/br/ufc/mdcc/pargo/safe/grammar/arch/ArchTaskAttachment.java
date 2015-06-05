package br.ufc.mdcc.pargo.safe.grammar.arch;

public class ArchTaskAttachment {

	private ArchTask taskA;
	private ArchTask taskB;
	
	public ArchTask getTaskA() {
		return taskA;
	}
	public void setTaskA(ArchTask taskA) {
		this.taskA = taskA;
	}
	public ArchTask getTaskB() {
		return taskB;
	}
	public void setTaskB(ArchTask taskB) {
		this.taskB = taskB;
	}
	
	@Override
	public String toString() {
		String res="";
		res+="\n"+this.taskA;
		res+="\n"+this.taskB;
		return res;
	}
}
