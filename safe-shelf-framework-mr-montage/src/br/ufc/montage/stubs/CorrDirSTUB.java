package br.ufc.montage.stubs;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.montage.ports.env.MontageProvidesPort;

public class CorrDirSTUB extends HShelfComponent{

	private MontageProvidesPort corrdir_prov_app;
	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		this.corrdir_prov_app = new MontageProvidesPort();
		corrdir_prov_app.setName("corrdir-prov-app");
		try {
			services.setProvidesPort(corrdir_prov_app);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
