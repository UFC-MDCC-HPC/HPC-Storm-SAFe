package br.ufc.montage.proxies;

import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.montage.ports.MontageShelfProvidesPort;
import br.ufc.montage.ports.MontageTypes;
import br.ufc.montage.ports.env.TblPortProvides;
import br.ufc.montage.ports.tsk.GoPortTask;

public class MProjExecProxie extends MontageShelfComputationComponent{

	private TblPortProvides tblPortProvides;
	
	private HShelfUsesPort tblPortUses;
	private HShelfUsesPort dirPortUsesIn;
	private HShelfUsesPort dirPortUsesOut;
	private HShelfUsesPort hdrPortUses;
	private GoPortTask goPortTask;
	
	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		
		//register uses and task
		this.goPortTask = new GoPortTask(this);
		this.goPortTask.setName("mprojexec-go");
		try {
			this.services.registerTaskPort(goPortTask);
			this.services.registerUsesPort("mprojexec-tbl-port-uses", MontageTypes.TBL_TYPE);
			this.services.registerUsesPort("mprojexec-dir-port-uses-in", MontageTypes.DIR_TYPE);
			this.services.registerUsesPort("mprojexec-dir-port-uses-out", MontageTypes.DIR_TYPE);
			this.services.registerUsesPort("mprojexec-hdr-port-uses", MontageTypes.HDR_TYPE);
		} catch (HShelfException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		//export provides
		this.tblPortProvides = new TblPortProvides();
		this.tblPortProvides.setName("mprojexec-tbl-port-provides");
		try {
			this.services.setProvidesPort(tblPortProvides);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void go() {
		
		String dirInValue = null;
		String dirOutValue = null;
		String tblValue = null;
		String hdrValue = null;
		
		try {
			this.tblPortUses = (HShelfUsesPort)this.services.getPort("mprojexec-tbl-port-uses");
			this.dirPortUsesIn = (HShelfUsesPort)this.services.getPort("mprojexec-dir-port-uses-in");
			this.dirPortUsesOut = (HShelfUsesPort)this.services.getPort("mprojexec-dir-port-uses-out");
			this.hdrPortUses = (HShelfUsesPort)this.services.getPort("mprojexec-hdr-port-uses");
			
			dirInValue = ((MontageShelfProvidesPort)this.dirPortUsesIn.getProvidesPort()).getValue();
			dirOutValue = ((MontageShelfProvidesPort)this.dirPortUsesOut.getProvidesPort()).getValue();
			tblValue = ((MontageShelfProvidesPort)this.tblPortUses.getProvidesPort()).getValue();
			hdrValue = ((MontageShelfProvidesPort)this.hdrPortUses.getProvidesPort()).getValue();
			
			//comunicar com o web service uses aqui, passando os 4 parâmetros a ele, conseguido da local
			//4 x WS_USES.SET_VALUE..
			
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//SIMULAÇAO DA CHAMADA REMOTA DO WEB SERVICE PELA PORTA GO
		//WS_GO.GO
		//begin some computation...
		String tblValueOut = " mprojexec.tbl";
		String cmd = "mProjExec -p " + dirInValue + " " + tblValue + " " + hdrValue + " " + dirOutValue + " " + tblValueOut;
		System.out.println(cmd);
		//end some computation!
		//FIM DA SIMULAÇÃO
		
		//comunicar com o web services aqui, provides, para pegar o valor calculado e colocar na porta local
		//WS_PROVIDES.GET_VALUE
		this.tblPortProvides.setValue(tblValueOut);
		
		
	}

}
