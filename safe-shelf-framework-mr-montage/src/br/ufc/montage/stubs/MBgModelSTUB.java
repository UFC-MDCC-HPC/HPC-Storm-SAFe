package br.ufc.montage.stubs;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.montage.ports.env.MontageProvidesPort;
import br.ufc.montage.ports.tsk.MontageTaskPort;

public class MBgModelSTUB extends HShelfComponent{
	private MontageProvidesPort mbgmodel_prov_app;
	private MontageTaskPort go;
	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		this.mbgmodel_prov_app = new MontageProvidesPort();
		mbgmodel_prov_app.setName("mbgmodel-prov-app");
		
		this.go = new MontageTaskPort();
		this.go.setName("mbgmodel-go");
		try {
			this.services.registerTaskPort(this.go);
		} catch (HShelfException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		
		try {
			services.setProvidesPort(mbgmodel_prov_app);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
}

