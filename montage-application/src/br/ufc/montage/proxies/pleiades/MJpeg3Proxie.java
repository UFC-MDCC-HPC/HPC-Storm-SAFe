package br.ufc.montage.proxies.pleiades;

import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.port.HShelfUsesPort;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.montage.ports.MontageShelfProvidesPort;
import br.ufc.montage.ports.MontageTypes;
import br.ufc.montage.ports.tsk.GoPortTask;
import br.ufc.montage.proxies.MontageShelfComputationComponent;
import br.ufc.montage.util.UnixUtil;

public class MJpeg3Proxie extends MontageShelfComputationComponent {

	
	private HShelfUsesPort fitsPortUses0;
	private HShelfUsesPort fitsPortUses1;
	private HShelfUsesPort fitsPortUses2;
	private GoPortTask goPortTask;

	@Override
	public void setServices(IHShelfService services) {
		this.services = services;

		this.goPortTask = new GoPortTask(this);
		this.goPortTask.setName("mjpeg3-go");

		try {
			this.services.registerTaskPort(goPortTask);
			this.services.registerUsesPort("mjpeg-fits-port-uses0",
					MontageTypes.FITS_TYPE);
			this.services.registerUsesPort("mjpeg-fits-port-uses1",
					MontageTypes.FITS_TYPE);
			this.services.registerUsesPort("mjpeg-fits-port-uses2",
					MontageTypes.FITS_TYPE);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	@Override
	public void go() {
		String fitsValue0 = null;
		String fitsValue1 = null;
		String fitsValue2 = null;
		
		
		try {
			this.fitsPortUses0 = (HShelfUsesPort) this.services
					.getPort("mjpeg-fits-port-uses0");
			fitsValue0 = ((MontageShelfProvidesPort) this.fitsPortUses0
					.getProvidesPort()).getValue();
			
			this.fitsPortUses1 = (HShelfUsesPort) this.services
					.getPort("mjpeg-fits-port-uses1");
			fitsValue1 = ((MontageShelfProvidesPort) this.fitsPortUses1
					.getProvidesPort()).getValue();
			
			this.fitsPortUses2 = (HShelfUsesPort) this.services
					.getPort("mjpeg-fits-port-uses2");
			fitsValue2 = ((MontageShelfProvidesPort) this.fitsPortUses2
					.getProvidesPort()).getValue();
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jpgValue = "resultado-pleiades.jpg";
		String path = "/home/jefferson/TEMP/pleiades/";
		String cmd = "mJPEG -blue "+path+fitsValue0+" -1s 99.999% gaussian-log"
				+ " -green "+path+fitsValue1+" -1s 99.999% gaussian-log"
						+ " -red "+path+fitsValue2+" -1s 99.999% gaussian-log"
								+ " -out "+path+jpgValue;
		
		

		//service.getIMJpegImplPort().setFitsPortUses(fitsValue);
		
		// SIMULAÇAO DA CHAMADA REMOTA DO WEB SERVICE PELA PORTA GO
		// WS_GO.GO
		// begin some computation...
		//mJPEG -gray final/m101_mosaic.fits 0s max gaussian-log -out final/m101_mosaic.jpg
		
		/*String cmd = "mJPEG -gray " + fitsValue + " 0s max gaussian-log -out " + jpgValue;
		System.out.println(cmd);*/
		//service.getIMJpegImplPort().go();
		//String jpgValue = service.getIMJpegImplPort().getJpgPortProvides();
		// end some computation!
		// FIM DA SIMULAÇÃO

		// comunicar com o web services aqui, provides, para pegar o valor
		// calculado e colocar na porta local
		// WS_PROVIDES.GET_VALUE
		System.out.println(cmd);
		UnixUtil.executeBinBash(cmd, path);
		

	}
}
