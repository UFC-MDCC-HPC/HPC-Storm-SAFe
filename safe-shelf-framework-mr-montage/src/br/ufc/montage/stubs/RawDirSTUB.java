package br.ufc.montage.stubs;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.montage.ports.env.MontageProvidesPort;

public class RawDirSTUB extends HShelfComponent{
	
	private MontageProvidesPort provides_dir;
	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		this.provides_dir = new MontageProvidesPort();
		provides_dir.setName("raw-dir-port");
		try {
			services.setProvidesPort(provides_dir);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
