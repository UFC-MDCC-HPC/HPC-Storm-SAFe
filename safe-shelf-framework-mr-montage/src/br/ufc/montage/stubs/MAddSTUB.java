package br.ufc.montage.stubs;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.montage.ports.env.MontageProvidesPort;
import br.ufc.montage.ports.tsk.MontageTaskPort;

public class MAddSTUB extends HShelfComponent{

	private MontageProvidesPort madd_prov_app;
	private MontageTaskPort go;
	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		this.madd_prov_app = new MontageProvidesPort();
		madd_prov_app.setName("madd-prov-app");
		
		this.go = new MontageTaskPort();
		this.go.setName("madd-go");
		try {
			this.services.registerTaskPort(this.go);
		} catch (HShelfException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		
		try {
			services.setProvidesPort(madd_prov_app);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
