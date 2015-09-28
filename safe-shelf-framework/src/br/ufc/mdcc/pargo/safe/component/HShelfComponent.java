package br.ufc.mdcc.pargo.safe.component;

import br.ufc.mdcc.pargo.safe.services.IHShelfService;

public abstract class HShelfComponent {

	private String name;
	protected IHShelfService services;
	
	public abstract void setServices(IHShelfService services);
	
	public IHShelfService getServices(){
		return this.services;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof HShelfComponent))
			return false;
		HShelfComponent ref = (HShelfComponent)obj;
		if(ref.getName().equals(this.name))
			return true;
		return false;
	}
}
