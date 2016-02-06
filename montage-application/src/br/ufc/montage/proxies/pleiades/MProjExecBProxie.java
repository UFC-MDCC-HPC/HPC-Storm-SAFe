package br.ufc.montage.proxies.pleiades;

import br.montage.stubs.mProjExec.IMProjExecImplService;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.montage.ports.MontageShelfProvidesPort;
import br.ufc.montage.ports.MontageTypes;
import br.ufc.montage.ports.env.TblPortProvides;
import br.ufc.montage.ports.tsk.GoPortTask;
import br.ufc.montage.proxies.MontageShelfComputationComponent;

public class MProjExecBProxie extends MontageShelfComputationComponent{

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
		this.goPortTask.setName("mprojexec-go-B");
		try {
			this.services.registerTaskPort(goPortTask);
			this.services.registerUsesPort("mprojexec-tbl-port-uses-B", MontageTypes.TBL_TYPE);
			this.services.registerUsesPort("mprojexec-dir-port-uses-in-B", MontageTypes.DIR_TYPE);
			this.services.registerUsesPort("mprojexec-dir-port-uses-out-B", MontageTypes.DIR_TYPE);
			this.services.registerUsesPort("mprojexec-hdr-port-uses-B", MontageTypes.HDR_TYPE);
		} catch (HShelfException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		//export provides
		this.tblPortProvides = new TblPortProvides();
		this.tblPortProvides.setName("mprojexec-tbl-port-provides-B");
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
		IMProjExecImplService service = new IMProjExecImplService();
		try {
			this.tblPortUses = (HShelfUsesPort)this.services.getPort("mprojexec-tbl-port-uses-B");
			this.dirPortUsesIn = (HShelfUsesPort)this.services.getPort("mprojexec-dir-port-uses-in-B");
			this.dirPortUsesOut = (HShelfUsesPort)this.services.getPort("mprojexec-dir-port-uses-out-B");
			this.hdrPortUses = (HShelfUsesPort)this.services.getPort("mprojexec-hdr-port-uses-B");
			
			dirInValue = ((MontageShelfProvidesPort)this.dirPortUsesIn.getProvidesPort()).getValue();
			dirOutValue = ((MontageShelfProvidesPort)this.dirPortUsesOut.getProvidesPort()).getValue();
			tblValue = ((MontageShelfProvidesPort)this.tblPortUses.getProvidesPort()).getValue();
			hdrValue = ((MontageShelfProvidesPort)this.hdrPortUses.getProvidesPort()).getValue();
			
			//comunicar com o web service uses aqui, passando os 4 parâmetros a ele, conseguido da local
			//4 x WS_USES.SET_VALUE..
			
			service.getIMProjExecImplPort().setDirPortUsesIn(dirInValue);
			service.getIMProjExecImplPort().setDirPortUsesOut(dirOutValue);
			service.getIMProjExecImplPort().setTblPortUses(tblValue);
			service.getIMProjExecImplPort().setHdrPortUses(hdrValue);
			
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//SIMULAÇAO DA CHAMADA REMOTA DO WEB SERVICE PELA PORTA GO
		//WS_GO.GO
		//begin some computation...
		
		/*String cmd = "mProjExec -p " + dirInValue + " " + tblValue + " " + hdrValue + " " + dirOutValue + " " + tblValueOut;
		System.out.println(cmd);*/
		service.getIMProjExecImplPort().go();
		String tblValueOut = service.getIMProjExecImplPort().getTblPortProvides();
		//end some computation!
		//FIM DA SIMULAÇÃO
		
		//comunicar com o web services aqui, provides, para pegar o valor calculado e colocar na porta local
		//WS_PROVIDES.GET_VALUE
		this.tblPortProvides.setValue(tblValueOut);
		
		
	}

}
