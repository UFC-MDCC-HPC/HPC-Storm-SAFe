package br.ufc.montage.proxies;

import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.port.IHShelfPortTypes;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.montage.ports.MontageShelfProvidesPort;
import br.ufc.montage.ports.tsk.GoPortTask;

public class MArchiveExecProxie extends MontageShelfComputationComponent{

	private HShelfUsesPort tblUses;
	private HShelfUsesPort dirUses;
	private GoPortTask goPortTask;
	
	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		this.goPortTask = new GoPortTask(this);
		this.goPortTask.setName("marchiveexec-go");
		
		try {
			this.services.registerUsesPort("marchive-uses-tbl", IHShelfPortTypes.NO_TYPE);
			this.services.registerUsesPort("marchive-uses-raw", IHShelfPortTypes.NO_TYPE);
			this.services.registerTaskPort(goPortTask);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void go() {
		String tblPortValue = null;
		String dirPortValue = null;
		try {
			this.dirUses = (HShelfUsesPort)this.services.getPort("marchive-uses-raw");
			dirPortValue = ((MontageShelfProvidesPort)this.dirUses.getProvidesPort()).getValue();
			
			this.tblUses = (HShelfUsesPort)this.services.getPort("marchive-uses-tbl");
			tblPortValue = ((MontageShelfProvidesPort)this.tblUses.getProvidesPort()).getValue();
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//SIMULAÇAO DA CHAMADA REMOTA DO WEB SERVICE PELA PORTA GO
		//WS_GO.GO
		//begin some computation... 
		
		String cmd = "cd "+dirPortValue+"\n";
		cmd += " mArchiveExec "+tblPortValue;
		System.out.println(cmd);
		//end some computation!
		//FIM DA SIMULAÇÃO
		
	}

}
