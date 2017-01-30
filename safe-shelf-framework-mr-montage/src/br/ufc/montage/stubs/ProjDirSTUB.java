package br.ufc.montage.stubs;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.montage.ports.env.MontageProvidesPort;

public class ProjDirSTUB extends HShelfComponent{
	private MontageProvidesPort projdir_prov_app;
	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		this.projdir_prov_app = new MontageProvidesPort();
		projdir_prov_app.setName("projdir-prov-app");
		try {
			services.setProvidesPort(this.projdir_prov_app);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
