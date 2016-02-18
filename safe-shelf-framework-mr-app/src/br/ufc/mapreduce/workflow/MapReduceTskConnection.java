package br.ufc.mapreduce.workflow;


public class MapReduceTskConnection extends MapReduceConnection{

	private String componentAName;
	private String portAName;
	
	private String componentBName;
	private String portBName;
	
	public MapReduceTskConnection(String componentAName, String portAName,
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
	public boolean equals(Object obj) {
		if(!(obj instanceof MapReduceTskConnection))
			return false;
		MapReduceTskConnection ref = (MapReduceTskConnection)obj;
		if(ref.getComponentAName().equals(this.componentAName) &&
		   ref.getPortAName().equals(this.portAName) &&
		   ref.getComponentBName().equals(this.componentBName) &&
		   ref.getPortBName().equals(this.portBName))
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		String res = this.componentAName+"#"+this.portAName+
				"->"+this.componentBName+"#"+this.portBName;
		return res;
	}
	
}
