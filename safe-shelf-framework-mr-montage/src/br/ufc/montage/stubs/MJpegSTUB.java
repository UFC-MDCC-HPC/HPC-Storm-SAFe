package br.ufc.montage.stubs;

import br.ufc.mdcc.pargo.safe.framework.component.HShelfComponent;
import br.ufc.mdcc.pargo.safe.framework.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.framework.services.IHShelfService;
import br.ufc.montage.ports.env.MontageProvidesPort;
import br.ufc.montage.ports.tsk.MontageTaskPort;

public class MJpegSTUB extends HShelfComponent{
	private MontageProvidesPort mjpeg_jpg_port_provides;
	private MontageTaskPort go;
	@Override
	public void setServices(IHShelfService services) {
		this.services = services;
		this.mjpeg_jpg_port_provides = new MontageProvidesPort();
		mjpeg_jpg_port_provides.setName("mjpeg-jpg-port-provides");
		
		this.go = new MontageTaskPort();
		this.go.setName("mjpeg-go");
		try {
			this.services.registerTaskPort(this.go);
		} catch (HShelfException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		
		try {
			services.setProvidesPort(mjpeg_jpg_port_provides);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
