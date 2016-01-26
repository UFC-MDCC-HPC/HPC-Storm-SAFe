package br.ufc.montage.proxies;

import br.montage.stubs.mMontageDir.IMontageDirImplService;
import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.montage.ports.env.DirPortProvides;

public class DiffDirProxie extends HShelfComponent{

	private DirPortProvides dirPortProvides;
	
	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		this.dirPortProvides = new DirPortProvides();
		this.dirPortProvides.setName("diff-dir-port");
		//GET VALUE FROM WS.GET
		IMontageDirImplService service = new IMontageDirImplService();
		String diffValue = service.getIMontageDirImplPort().getDiffDir();
		this.dirPortProvides.setValue(diffValue);
		try {
			this.services.setProvidesPort(this.dirPortProvides);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
