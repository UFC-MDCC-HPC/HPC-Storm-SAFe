package br.ufc.montage.proxies;

import br.montage.stubs.mArchiveList.IMArchiveListImplService;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.port.IHShelfPortTypes;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.montage.ports.MontageShelfProvidesPort;
import br.ufc.montage.ports.env.TblPortProvides;
import br.ufc.montage.ports.tsk.GoPortTask;

public class MArchiveListProxie extends MontageShelfComputationComponent{

	private TblPortProvides tblProvides;
	private HShelfUsesPort rawUses;
	private GoPortTask goPortTask;
	
	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		this.goPortTask = new GoPortTask(this);
		this.goPortTask.setName("marchivelist-go");
		
		try {
			this.services.registerUsesPort("marchivelist-uses-raw", IHShelfPortTypes.NO_TYPE);
			this.tblProvides = new TblPortProvides();
			tblProvides.setName("marchivelist-prov-tbl");
			this.services.setProvidesPort(tblProvides);
			this.services.registerTaskPort(goPortTask);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void go() {
		String dirPortValue = null;
		IMArchiveListImplService service = new IMArchiveListImplService();
		try {
			this.rawUses = (HShelfUsesPort)this.services.getPort("marchivelist-uses-raw");
			dirPortValue = ((MontageShelfProvidesPort)this.rawUses.getProvidesPort()).getValue();
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		service.getIMArchiveListImplPort().setRawUses(dirPortValue);
		
		
		//SIMULAÇAO DA CHAMADA REMOTA DO WEB SERVICE PELA PORTA GO
		//WS_GO.GO
		//begin some computation... 
		/*String tblValue = "imgbtl.tbl";
		String cmd = "cd "+dirPortValue+"\n";
		cmd += "mArchiveList dss DSS2B \"56.5 23.75\" 3 3 "+tblValue;
		System.out.println(cmd);*/
		service.getIMArchiveListImplPort().go();
		//end some computation!
		//FIM DA SIMULAÇÃO
		
		//comunicar com o web services aqui, provides, para pegar o valor calculado e colocar na porta local
		//WS_PROVIDES.GET_VALUE
		this.tblProvides.setValue(service.getIMArchiveListImplPort().getTblProvides());
		
	}

}
