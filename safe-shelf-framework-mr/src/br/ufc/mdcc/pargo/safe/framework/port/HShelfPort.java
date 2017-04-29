package br.ufc.mdcc.pargo.safe.framework.port;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;


public abstract class HShelfPort {

	private String name;
	private HShelfComponent parentComponent;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HShelfComponent getParentComponent() {
		return parentComponent;
	}

	public void setParentComponent(HShelfComponent parentComponent) {
		this.parentComponent = parentComponent;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof HShelfPort))
			return false;
		
		HShelfPort ref = (HShelfPort)obj;
		String parentName = this.parentComponent.getName();
		String refParentName = ref.getParentComponent().getName();
		if(ref.getName().equals(this.name) && refParentName.equals(parentName))
			return true;
		return false;
	}
}
