package br.ufc.montage.proxies.pleiades;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.montage.ports.env.DirPortProvides;

public class FitsDirProxie extends HShelfComponent{

	private DirPortProvides dirPortProvidesA;
	private DirPortProvides dirPortProvidesB;
	private DirPortProvides dirPortProvidesC;
	
	@Override
	public void setServices(IHShelfService services) {
		
		this.services = services;
		
		this.dirPortProvidesA = new DirPortProvides();
		this.dirPortProvidesA.setName("fits-dir-port-A-D");
		this.dirPortProvidesA.setValue("mosaic0.fits");
		
		this.dirPortProvidesB = new DirPortProvides();
		this.dirPortProvidesB.setName("fits-dir-port-B-D");
		this.dirPortProvidesB.setValue("mosaic1.fits");
		
		this.dirPortProvidesC = new DirPortProvides();
		this.dirPortProvidesC.setName("fits-dir-port-C-D");
		this.dirPortProvidesC.setValue("mosaic2.fits");
		
		try {
			this.services.setProvidesPort(this.dirPortProvidesA);
			this.services.setProvidesPort(this.dirPortProvidesB);
			this.services.setProvidesPort(this.dirPortProvidesC);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
