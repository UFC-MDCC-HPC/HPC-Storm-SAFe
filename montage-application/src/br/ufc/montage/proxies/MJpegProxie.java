package br.ufc.montage.proxies;

import br.montage.stubs.mJpeg.IMJpegImplService;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.montage.ports.MontageShelfProvidesPort;
import br.ufc.montage.ports.MontageTypes;
import br.ufc.montage.ports.env.JpgPortProvides;
import br.ufc.montage.ports.tsk.GoPortTask;

public class MJpegProxie extends MontageShelfComputationComponent {

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
			this.services.registerUsesPort("mjpeg-fits-port-uses",
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
		IMJpegImplService service = new IMJpegImplService();
		
		try {
			this.fitsPortUses = (HShelfUsesPort) this.services
					.getPort("mjpeg-fits-port-uses");
			fitsValue = ((MontageShelfProvidesPort) this.fitsPortUses
					.getProvidesPort()).getValue();
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		service.getIMJpegImplPort().setFitsPortUses(fitsValue);
		
		// SIMULAÇAO DA CHAMADA REMOTA DO WEB SERVICE PELA PORTA GO
		// WS_GO.GO
		// begin some computation...
		//mJPEG -gray final/m101_mosaic.fits 0s max gaussian-log -out final/m101_mosaic.jpg
		
		/*String cmd = "mJPEG -gray " + fitsValue + " 0s max gaussian-log -out " + jpgValue;
		System.out.println(cmd);*/
		service.getIMJpegImplPort().go();
		String jpgValue = service.getIMJpegImplPort().getJpgPortProvides();
		// end some computation!
		// FIM DA SIMULAÇÃO

		// comunicar com o web services aqui, provides, para pegar o valor
		// calculado e colocar na porta local
		// WS_PROVIDES.GET_VALUE
		this.jpgPortProvides.setValue(jpgValue);

	}
}
