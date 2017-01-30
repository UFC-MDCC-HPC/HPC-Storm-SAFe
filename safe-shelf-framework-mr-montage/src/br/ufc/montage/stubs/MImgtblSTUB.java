package br.ufc.montage.stubs;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.montage.ports.env.MontageProvidesPort;
import br.ufc.montage.ports.tsk.MontageTaskPort;

public class MImgtblSTUB extends HShelfComponent{
	private MontageProvidesPort mimgtbl_prov_app;
	private MontageTaskPort go;
	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		this.mimgtbl_prov_app = new MontageProvidesPort();
		mimgtbl_prov_app.setName("corrdir-prov-app");
		
		this.go = new MontageTaskPort();
		this.go.setName("mimgtbl-go");
		try {
			this.services.registerTaskPort(this.go);
		} catch (HShelfException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		
		try {
			services.setProvidesPort(mimgtbl_prov_app);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
