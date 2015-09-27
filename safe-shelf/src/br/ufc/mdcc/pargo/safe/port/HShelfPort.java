package br.ufc.mdcc.pargo.safe.port;


public abstract class HShelfPort {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof HShelfPort))
			return false;
		HShelfPort ref = (HShelfPort)obj;
		if(ref.getName().equals(this.name))
			return true;
		return false;
	}
}
