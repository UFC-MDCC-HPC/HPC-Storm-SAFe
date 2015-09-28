package br.ufc.mdcc.pargo.safe.sample;

/**
 * Application
 */
import br.ufc.mdcc.pargo.safe.application.HShelfApplication;
import br.ufc.mdcc.pargo.safe.exception.HShelfException;
import br.ufc.mdcc.pargo.safe.port.HShelfPort;
import br.ufc.mdcc.pargo.safe.services.IHShelfService;

public class SAfeSampleApplication extends HShelfApplication{

	
	
	public SAfeSampleApplication(String name) {
		super(name);
	}

	@Override
	public void setServices(IHShelfService services) {
		this.services = services; 
	}
	
	
	public static void main(String[] args) {
		SAfeSampleApplication sampleApp = new SAfeSampleApplication("sample-app");
		IHShelfService services = sampleApp.getServices();
		try {
		 
			System.out.println("Teste");
			HShelfPort port = services.getProvidesPort("safeswl-port");
			System.out.println("OUT:" + port);
		} catch (HShelfException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
