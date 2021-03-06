package br.ufc.montage.proxies;

import br.montage.stubs.mMontageDir.IMontageDirImplService;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.montage.ports.env.DirPortProvides;

public class ProjDirProxie extends HShelfComponent{

	private DirPortProvides dirPortProvides;
	
	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		this.dirPortProvides = new DirPortProvides();
		this.dirPortProvides.setName("proj-dir-port");
		//GET VALUE FROM WS.GET
		IMontageDirImplService service = new IMontageDirImplService();
		String projValue = service.getIMontageDirImplPort().getProjDir();
		this.dirPortProvides.setValue(projValue);
		try {
			this.services.setProvidesPort(this.dirPortProvides);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
