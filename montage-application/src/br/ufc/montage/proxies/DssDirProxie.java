package br.ufc.montage.proxies;

import br.montage.stubs.mMontageDir.IMontageDirImplService;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.montage.ports.env.DirPortProvides;

public class DssDirProxie extends HShelfComponent{

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		IMontageDirImplService service = new IMontageDirImplService();
		
		
		DirPortProvides projected = new DirPortProvides();
		projected.setName("dss-dir-proj");
		projected.setValue(service.getIMontageDirImplPort().getProjDir());
		DirPortProvides raw = new DirPortProvides();
		raw.setName("dss-dir-raw");
		raw.setValue(service.getIMontageDirImplPort().getRawDir());
		
		try {
			this.services.setProvidesPort(projected);
			this.services.setProvidesPort(raw);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
}
