package br.ufc.montage.model;

public class MontageEnvConnection {
	
	private String providesCompName;
	private String providesPortName;

	private String usesCompName;
	private String usesPortName;
	
	public MontageEnvConnection(String providesCompName,
			String providesPortName, String usesCompName, String usesPortName) {
		
		this.providesCompName = providesCompName;
		this.providesPortName = providesPortName;
		this.usesCompName = usesCompName;
		this.usesPortName = usesPortName;
	}
	
	public String getProvidesCompName() {
		return providesCompName;
	}
	public void setProvidesCompName(String providesCompName) {
		this.providesCompName = providesCompName;
	}
	public String getProvidesPortName() {
		return providesPortName;
	}
	public void setProvidesPortName(String providesPortName) {
		this.providesPortName = providesPortName;
	}
	public String getUsesCompName() {
		return usesCompName;
	}
	public void setUsesCompName(String usesCompName) {
		this.usesCompName = usesCompName;
	}
	public String getUsesPortName() {
		return usesPortName;
	}
	public void setUsesPortName(String usesPortName) {
		this.usesPortName = usesPortName;
	}
	
	
}
