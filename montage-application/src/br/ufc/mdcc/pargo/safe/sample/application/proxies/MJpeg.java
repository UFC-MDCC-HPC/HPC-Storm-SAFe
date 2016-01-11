package br.ufc.mdcc.pargo.safe.sample.application.proxies;

import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.mdcc.pargo.safe.sample.application.ports.MontageShelfProvidesPort;
import br.ufc.mdcc.pargo.safe.sample.application.ports.MontageTypes;
import br.ufc.mdcc.pargo.safe.sample.application.ports.env.FitsPortUses;
import br.ufc.mdcc.pargo.safe.sample.application.ports.env.JpgPortProvides;
import br.ufc.mdcc.pargo.safe.sample.application.ports.tsk.GoPortTask;

public class MJpeg extends MontageShelfComputationComponent {

	private JpgPortProvides jpgPortProvides;
	private HShelfUsesPort fitsPortUses;
	private GoPortTask goPortTask;

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;

		this.goPortTask = new GoPortTask(this);
		this.goPortTask.setName("mjpeg-go");

		try {
			this.services.registerTaskPort(goPortTask);
			this.services.registerUsesPort("mjpeg-fist-port-uses",
					MontageTypes.FITS_TYPE);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.jpgPortProvides = new JpgPortProvides();
		this.jpgPortProvides.setName("mjpeg-jpg-port-provides");

		try {
			this.services.setProvidesPort(jpgPortProvides);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void go() {
		String fitsValue = null;

		try {
			this.fitsPortUses = (HShelfUsesPort) this.services
					.getPort("mjpeg-fist-port-uses");
			fitsValue = ((MontageShelfProvidesPort) this.fitsPortUses
					.getProvidesPort()).getValue();
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// SIMULAÇAO DA CHAMADA REMOTA DO WEB SERVICE PELA PORTA GO
		// WS_GO.GO
		// begin some computation...
		//mJPEG -gray final/m101_mosaic.fits 0s max gaussian-log -out final/m101_mosaic.jpg
		String jpgValue = "m101_mosaic.jpg";
		String cmd = "mJPEG -gray " + fitsValue + " 0s max gaussian-log -out " + jpgValue;
		System.out.println(cmd);
		// end some computation!
		// FIM DA SIMULAÇÃO

		// comunicar com o web services aqui, provides, para pegar o valor
		// calculado e colocar na porta local
		// WS_PROVIDES.GET_VALUE
		this.jpgPortProvides.setValue(jpgValue);

	}
}
