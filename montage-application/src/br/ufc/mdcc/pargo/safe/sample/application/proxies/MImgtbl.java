package br.ufc.mdcc.pargo.safe.sample.application.proxies;

import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.sample.application.ports.MontageShelfProvidesPort;
import br.ufc.mdcc.pargo.safe.sample.application.ports.MontageTypes;
import br.ufc.mdcc.pargo.safe.sample.application.ports.env.TblPortProvides;
import br.ufc.mdcc.pargo.safe.sample.application.ports.tsk.GoPortTask;

public class MImgtbl extends MontageShelfComputationComponent{

	private TblPortProvides tblPortProvides;
	private HShelfUsesPort rawDirPortUses;
	private HShelfUsesPort projDirPortUses;
	private GoPortTask goPortTask;
	
	
	private int turn = 0;
	
	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
	
		//register uses and task
		this.goPortTask = new GoPortTask(this);
		this.goPortTask.setName("mimgtbl-go");
		
		try {
			
			this.services.registerTaskPort(goPortTask);
			this.services.registerUsesPort("mimgtbl-raw-dir-port-uses", MontageTypes.DIR_TYPE);
			this.services.registerUsesPort("mimgtbl-proj-dir-port-uses", MontageTypes.DIR_TYPE);
		} catch (HShelfException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		//export provides
		this.tblPortProvides = new TblPortProvides();
		this.tblPortProvides.setName("mimgtbl-tbl-port-provides");
		try {
			this.services.setProvidesPort(tblPortProvides);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void go() {
		String dirPortValue = null;
		try {
			
			if(turn==0){
				this.rawDirPortUses = (HShelfUsesPort)this.services.getPort("mimgtbl-raw-dir-port-uses");
				dirPortValue = ((MontageShelfProvidesPort)this.rawDirPortUses.getProvidesPort()).getValue();
				turn = 1;
			}else{
				this.projDirPortUses = (HShelfUsesPort)this.services.getPort("mimgtbl-proj-dir-port-uses");
				dirPortValue = ((MontageShelfProvidesPort)this.projDirPortUses.getProvidesPort()).getValue();
			}
				
			//comunicar com o web service uses aqui, passando o parâmetro a ele, conseguido da local
			//WS_USES.SET_VALUE...
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//SIMULAÇAO DA CHAMADA REMOTA DO WEB SERVICE PELA PORTA GO
		//WS_GO.GO
		//begin some computation... 
		String tblValue = "imgbtl-tbl";
		String cmd = "mImgtbl "+dirPortValue+" "+tblValue;
		System.out.println(cmd);
		//end some computation!
		//FIM DA SIMULAÇÃO
		
		//comunicar com o web services aqui, provides, para pegar o valor calculado e colocar na porta local
		//WS_PROVIDES.GET_VALUE
		this.tblPortProvides.setValue(tblValue);
		
	}

}
