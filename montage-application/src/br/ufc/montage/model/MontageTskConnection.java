package br.ufc.montage.model;

public class MontageTskConnection {

	private String componentAName;
	private String portAName;
	
	private String componentBName;
	private String portBName;
	
	public MontageTskConnection(String componentAName, String portAName,
			String componentBName, String portBName) {
		
		this.componentAName = componentAName;
		this.portAName = portAName;
		this.componentBName = componentBName;
		this.portBName = portBName;
	}
	
	public String getComponentAName() {
		return componentAName;
	}
	public void setComponentAName(String componentAName) {
		this.componentAName = componentAName;
	}
	public String getPortAName() {
		return portAName;
	}
	public void setPortAName(String portAName) {
		this.portAName = portAName;
	}
	public String getComponentBName() {
		return componentBName;
	}
	public void setComponentBName(String componentBName) {
		this.componentBName = componentBName;
	}
	public String getPortBName() {
		return portBName;
	}
	public void setPortBName(String portBName) {
		this.portBName = portBName;
	}
	
	@Override
	public String toString() {
		String res = this.componentAName+"#"+this.portAName+
				"->"+this.componentBName+"#"+this.portBName;
		return res;
	}
	
}
