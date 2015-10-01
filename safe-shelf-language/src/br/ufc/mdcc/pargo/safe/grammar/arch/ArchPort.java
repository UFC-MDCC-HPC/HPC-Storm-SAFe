package br.ufc.mdcc.pargo.safe.grammar.arch;


public class ArchPort implements IArchObject{

	private String name;
	private Integer id;
	private String wsdlPath;
	
	
	public ArchPort(){
		this.name = "";
	}
	
	public ArchPort(String name) {
		
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getWsdlPath() {
		return wsdlPath;
	}

	public void setWsdlPath(String wsdlPath) {
		this.wsdlPath = wsdlPath;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof ArchPort)) return false;
		
		ArchPort port = (ArchPort)obj;
		if(port.getId().intValue()!=this.getId().intValue())
			return false;

		return true;
	}
	
	@Override
	public String toString() {
		return "PORT ID: "+this.id+" NAME:" +this.name +" TYPE: "+ this.getClass().getSimpleName();
	}
}
