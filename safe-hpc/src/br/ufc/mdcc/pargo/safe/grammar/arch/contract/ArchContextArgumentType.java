package br.ufc.mdcc.pargo.safe.grammar.arch.contract;

public class ArchContextArgumentType {

	private String parameterId;
	private String variable;
	private ArchComponentFunctorApplicationType type;
	
	
	public String getParameterId() {
		return parameterId;
	}
	public void setParameterId(String parameterId) {
		this.parameterId = parameterId;
	}
	public String getVariable() {
		return variable;
	}
	public void setVariable(String variable) {
		this.variable = variable;
	}
	public ArchComponentFunctorApplicationType getType() {
		return type;
	}
	public void setType(ArchComponentFunctorApplicationType type) {
		this.type = type;
	}
	
	
}
