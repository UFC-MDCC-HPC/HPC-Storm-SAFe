package br.ufc.montage.proxies;

import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.montage.ports.MontageShelfProvidesPort;
import br.ufc.montage.ports.MontageTypes;
import br.ufc.montage.ports.env.TblPortProvides;
import br.ufc.montage.ports.tsk.GoPortTask;

public class MOverlapsProxie extends MontageShelfComputationComponent {

	private TblPortProvides tblPortProvides;
	private HShelfUsesPort tblPortUses;
	private GoPortTask goPortTask;

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;

		// register uses and task
		this.goPortTask = new GoPortTask(this);
		this.goPortTask.setName("moverlaps-go");

		try {
			this.services.registerTaskPort(goPortTask);
			this.services.registerUsesPort("moverlaps-tbl-port-uses",
					MontageTypes.TBL_TYPE);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.tblPortProvides = new TblPortProvides();
		this.tblPortProvides.setName("moverlaps-tbl-port-provides");
		try {
			this.services.setProvidesPort(tblPortProvides);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void go() {
		// mOverlaps images.tbl diffs.tbl

		String tblValueIn = null;
		try {
			this.tblPortUses = (HShelfUsesPort) this.services
					.getPort("moverlaps-tbl-port-uses");
			tblValueIn = ((MontageShelfProvidesPort) this.tblPortUses
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
		String tblValueOut = "diffs.tbl";
		String cmd = "mOverlaps " + tblValueIn + " " + tblValueOut;
		System.out.println(cmd);
		// end some computation!
		// FIM DA SIMULAÇÃO

		// comunicar com o web services aqui, provides, para pegar o valor
		// calculado e colocar na porta local
		// WS_PROVIDES.GET_VALUE
		this.tblPortProvides.setValue(tblValueOut);

	}

}
