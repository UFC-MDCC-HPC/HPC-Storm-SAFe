package br.ufc.mdcc.pargo.safe.sample.application.proxies;

import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.sample.application.ports.MontageShelfProvidesPort;
import br.ufc.mdcc.pargo.safe.sample.application.ports.MontageTypes;
import br.ufc.mdcc.pargo.safe.sample.application.ports.env.FitsPortProvides;
import br.ufc.mdcc.pargo.safe.sample.application.ports.tsk.GoPortTask;

public class MAdd extends MontageShelfComputationComponent {

	private FitsPortProvides fitsPortProvides;

	private HShelfUsesPort tblPortUses;
	private HShelfUsesPort dirPortUses;
	private HShelfUsesPort hdrPortUses;

	private GoPortTask goPortTask;

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;

		this.goPortTask = new GoPortTask(this);
		this.goPortTask.setName("madd-go");

		try {
			this.services.registerTaskPort(goPortTask);
			this.services.registerUsesPort("madd-tbl-port-uses",
					MontageTypes.TBL_TYPE);
			this.services.registerUsesPort("madd-dir-port-uses",
					MontageTypes.DIR_TYPE);
			this.services.registerUsesPort("madd-hdr-port-uses",
					MontageTypes.HDR_TYPE);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.fitsPortProvides = new FitsPortProvides();
		this.fitsPortProvides.setName("madd-fits-port-provides");

		try {
			this.services.setProvidesPort(fitsPortProvides);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void go() {
		String tblValueIn = null;
		String dirValue = null;
		String hdrValue = null;

		try {
			this.tblPortUses = (HShelfUsesPort) this.services
					.getPort("madd-tbl-port-uses");
			tblValueIn = ((MontageShelfProvidesPort) this.tblPortUses
					.getProvidesPort()).getValue();

			this.dirPortUses = (HShelfUsesPort) this.services
					.getPort("madd-dir-port-uses");
			dirValue = ((MontageShelfProvidesPort) this.dirPortUses
					.getProvidesPort()).getValue();

			this.hdrPortUses = (HShelfUsesPort) this.services
					.getPort("madd-hdr-port-uses");
			hdrValue = ((MontageShelfProvidesPort) this.hdrPortUses
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
		// mAdd -p corrdir images.tbl template.hdr final/m101_mosaic.fits
		String fitsOut = "m101_mosaic.fits";
		String cmd = "mAdd -p " + dirValue + " " + tblValueIn + " "
				+ hdrValue + " " + fitsOut;
		System.out.println(cmd);
		// end some computation!
		// FIM DA SIMULAÇÃO

		// comunicar com o web services aqui, provides, para pegar o valor
		// calculado e colocar na porta local
		// WS_PROVIDES.GET_VALUE
		this.fitsPortProvides.setValue(fitsOut);
	}

}
