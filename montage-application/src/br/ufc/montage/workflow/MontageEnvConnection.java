package br.ufc.montage.workflow;


public class MontageEnvConnection extends MontageConnection{
	
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
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof MontageEnvConnection))
			return false;
		MontageEnvConnection ref = (MontageEnvConnection)obj;
		if(ref.getProvidesCompName().equals(this.providesCompName)
		   &&
		   ref.getProvidesPortName().equals(this.providesPortName)
		   &&
		   ref.getUsesCompName().equals(this.usesCompName)
		   &&
		   ref.getUsesPortName().equals(this.usesPortName)
		   )
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		String res = this.usesCompName+"#"+this.usesPortName+
				"->"+this.providesCompName+"#"+this.providesPortName;
		return res;
	}
	
}
