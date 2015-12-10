package br.ufc.montage.model;

public class MontageEnvPort extends MontageModel{

	public static final String PROVIDES_PORT = "PROVIDES_PORT";
	public static final String USES_PORT = "USES_PORT";
	
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
