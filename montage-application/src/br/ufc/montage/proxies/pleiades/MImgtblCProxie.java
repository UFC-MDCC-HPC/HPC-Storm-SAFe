package br.ufc.montage.proxies.pleiades;

import br.montage.stubs.mImgtbl.IMIgtblImplService;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.montage.ports.MontageShelfProvidesPort;
import br.ufc.montage.ports.MontageTypes;
import br.ufc.montage.ports.env.TblPortProvides;
import br.ufc.montage.ports.tsk.GoPortTask;
import br.ufc.montage.proxies.MontageShelfComputationComponent;

public class MImgtblCProxie extends MontageShelfComputationComponent{

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
		this.goPortTask.setName("mimgtbl-go-C");
		
		try {
			
			this.services.registerTaskPort(goPortTask);
			this.services.registerUsesPort("mimgtbl-raw-dir-port-uses-C", MontageTypes.DIR_TYPE);
			this.services.registerUsesPort("mimgtbl-proj-dir-port-uses-C", MontageTypes.DIR_TYPE);
		} catch (HShelfException e1) {
			e1.printStackTrace();
		}
	
		//export provides
		this.tblPortProvides = new TblPortProvides();
		this.tblPortProvides.setName("mimgtbl-tbl-port-provides-C");
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
		IMIgtblImplService service = new IMIgtblImplService();
		try {
			
			if(turn==0){
				this.rawDirPortUses = (HShelfUsesPort)this.services.getPort("mimgtbl-raw-dir-port-uses-C");
				dirPortValue = ((MontageShelfProvidesPort)this.rawDirPortUses.getProvidesPort()).getValue();
				turn = 1;
			}else{
				this.projDirPortUses = (HShelfUsesPort)this.services.getPort("mimgtbl-proj-dir-port-uses-C");
				dirPortValue = ((MontageShelfProvidesPort)this.projDirPortUses.getProvidesPort()).getValue();
			}
				
			//comunicar com o web service uses aqui, passando o parâmetro a ele, conseguido da local
			//WS_USES.SET_VALUE...
			service.getIMIgtblImplPort().setDirPortUses(dirPortValue);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//SIMULAÇAO DA CHAMADA REMOTA DO WEB SERVICE PELA PORTA GO
		//WS_GO.GO
		//begin some computation... 
		
		/*String cmd = "mImgtbl "+dirPortValue+" "+tblValue;
		System.out.println(cmd);*/
		service.getIMIgtblImplPort().go();
		String tblValue = service.getIMIgtblImplPort().getTblPortProvides();
		//end some computation!
		//FIM DA SIMULAÇÃO
		
		//comunicar com o web services aqui, provides, para pegar o valor calculado e colocar na porta local
		//WS_PROVIDES.GET_VALUE
		
		this.tblPortProvides.setValue(tblValue);
		
	}

}
