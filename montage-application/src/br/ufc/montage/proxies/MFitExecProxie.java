package br.ufc.montage.proxies;

import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.montage.ports.MontageShelfProvidesPort;
import br.ufc.montage.ports.MontageTypes;
import br.ufc.montage.ports.env.TblPortProvides;
import br.ufc.montage.ports.tsk.GoPortTask;

public class MFitExecProxie extends MontageShelfComputationComponent {

	private TblPortProvides tblPortProvides;

	private HShelfUsesPort tblPortUses;
	private HShelfUsesPort dirPortUses;
	private GoPortTask goPortTask;

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;

		this.goPortTask = new GoPortTask(this);
		this.goPortTask.setName("mfitexec-go");

		try {
			this.services.registerTaskPort(goPortTask);
			this.services.registerUsesPort("mfitexec-tbl-port-uses",
					MontageTypes.TBL_TYPE);
			this.services.registerUsesPort("mfitexec-dir-port-uses",
					MontageTypes.DIR_TYPE);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.tblPortProvides = new TblPortProvides();
		this.tblPortProvides.setName("mfitexec-tbl-port-provides");
		try {
			this.services.setProvidesPort(tblPortProvides);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void go() {
		
		String tblValueIn = null;
		String dirValue = null;

		try {
			this.tblPortUses = (HShelfUsesPort) this.services
					.getPort("mfitexec-tbl-port-uses");
			tblValueIn = ((MontageShelfProvidesPort) tblPortUses
					.getProvidesPort()).getValue();

			this.dirPortUses = (HShelfUsesPort) this.services
					.getPort("mfitexec-dir-port-uses");
			dirValue = ((MontageShelfProvidesPort) dirPortUses
					.getProvidesPort()).getValue();

			// comunicar com o web service uses aqui, passando o parâmetro a
			// ele, conseguido da local
			// WS_USES.SET_VALUE...
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// SIMULAÇAO DA CHAMADA REMOTA DO WEB SERVICE PELA PORTA GO
		// WS_GO.GO
		// begin some computation...
		//mFitExec diffs.tbl fits.tbl diffdir
		String tblValueOut = "fits.tbl";
		String cmd = "mFitExec " + tblValueIn + " " + tblValueOut + " " + dirValue;
		System.out.println(cmd);
		// end some computation!
		// FIM DA SIMULAÇÃO
		
		//comunicar com o web services aqui, provides, para pegar o valor calculado e colocar na porta local
		//WS_PROVIDES.GET_VALUE
		this.tblPortProvides.setValue(tblValueOut);

	}
}
