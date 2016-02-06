package br.ufc.montage.proxies.pleiades;

import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.montage.ports.env.DirPortProvides;
import br.ufc.montage.proxies.DssDirProxie;

public class Dss2irDirProxie extends DssDirProxie{

	private DirPortProvides dirPortProvidesRaw;
	private DirPortProvides dirPortProvidesProj;
	
	@Override
	public void setServices(IHShelfService services) {
		// TODO Auto-generated method stub
		this.services = services;
		this.dirPortProvidesRaw = new DirPortProvides();
		this.dirPortProvidesRaw.setName("dss2ir-raw");
		this.dirPortProvidesRaw.setValue("dss2ir/raw");
		
		this.dirPortProvidesProj = new DirPortProvides();
		this.dirPortProvidesProj.setName("dss2ir-proj");
		this.dirPortProvidesProj.setValue("dss2ir/proj");
		
		try {
			this.services.setProvidesPort(this.dirPortProvidesProj);
			this.services.setProvidesPort(this.dirPortProvidesRaw);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
