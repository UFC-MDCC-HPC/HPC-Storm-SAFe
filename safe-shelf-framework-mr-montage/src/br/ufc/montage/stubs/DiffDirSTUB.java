package br.ufc.montage.stubs;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.montage.ports.env.MontageProvidesPort;

public class DiffDirSTUB extends HShelfComponent{

	private MontageProvidesPort diffdir_prov_app;
	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		this.diffdir_prov_app = new MontageProvidesPort();
		diffdir_prov_app.setName("diffdir-prov-app");
		try {
			services.setProvidesPort(this.diffdir_prov_app);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
